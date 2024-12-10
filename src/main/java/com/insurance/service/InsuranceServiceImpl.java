package com.insurance.service;

import com.insurance.controller.client.ExternalInsuranceClient;
import com.insurance.dto.InsuranceResponse;
import com.insurance.entity.Insurance;
import com.insurance.exception.ApiException;
import com.insurance.exception.ErrorCode;
import com.insurance.repository.InsuranceRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@ApplicationScoped
public class InsuranceServiceImpl implements InsuranceService {

    @Inject
    @RestClient
    ExternalInsuranceClient externalClient;

    @Inject
    InsuranceRepository repository;

    @Override
    @Transactional
    public CompletionStage<InsuranceResponse> fetchAndSaveInsuranceData(String policyNumber) {
        return CompletableFuture.supplyAsync(() -> {
            try {

                Insurance externalData = externalClient.getInsuranceData(policyNumber);

                repository.persist(externalData);

                return mapToResponse(externalData);
            } catch (Exception e) {
                throw new ApiException(ErrorCode.EXTERNAL_API_ERROR);
            }
        });
    }

    private InsuranceResponse mapToResponse(Insurance insurance) {
        return new InsuranceResponse(
                insurance.getId(),
                insurance.getPolicyNumber(),
                insurance.getCustomerName(),
                insurance.getType(),
                insurance.getPremium(),
                insurance.getStartDate(),
                insurance.getEndDate(),
                determineInsuranceStatus(insurance)
        );
    }
    private String determineInsuranceStatus(Insurance insurance) {
        LocalDateTime now = LocalDateTime.now();

        if (insurance.getEndDate() == null) {
            return "INVALID";
        }

        if (now.isBefore(insurance.getStartDate())) {
            return "PENDING";
        }

        if (now.isAfter(insurance.getEndDate())) {
            return "EXPIRED";
        }

        return "ACTIVE";
    }
}
