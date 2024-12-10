package com.insurance.controller.client;

import com.insurance.entity.Insurance;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api")
@RegisterRestClient(configKey = "insurance-api")
public interface ExternalInsuranceClient {
    @GET
    @Path("/insurance/{policyNumber}")
    Insurance getInsuranceData(@PathParam("policyNumber") String policyNumber);
}