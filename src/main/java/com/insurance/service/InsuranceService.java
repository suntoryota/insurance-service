package com.insurance.service;

import com.insurance.dto.InsuranceResponse;

import java.util.concurrent.CompletionStage;

public interface InsuranceService {
    CompletionStage<InsuranceResponse> fetchAndSaveInsuranceData(String policyNumber);
}