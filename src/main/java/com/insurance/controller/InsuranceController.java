package com.insurance.controller;

import com.insurance.dto.BaseResponse;
import com.insurance.dto.InsuranceResponse;
import com.insurance.service.InsuranceService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.concurrent.CompletionStage;

@Path("/api/insurance")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class InsuranceController {

    @Inject
    InsuranceService insuranceService;

    @GET
    @Path("/{policyNumber}")
    public CompletionStage<BaseResponse<InsuranceResponse>> getInsuranceData(
            @PathParam("policyNumber") String policyNumber) {
        return insuranceService.fetchAndSaveInsuranceData(policyNumber)
                .thenApply(data -> new BaseResponse<>(true, "Success", data));
    }
}
