package com.insurance.repository;

import com.insurance.entity.Insurance;
import jakarta.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class InsuranceRepository implements PanacheRepository<Insurance> {
    public Insurance findByPolicyNumber(String policyNumber) {
        return find("policyNumber", policyNumber).firstResult();
    }
}
