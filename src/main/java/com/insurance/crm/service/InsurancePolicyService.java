package com.insurance.crm.service;

import com.insurance.crm.entity.InsurancePolicy;

import java.util.List;
import java.util.Optional;

public interface InsurancePolicyService {
    List<InsurancePolicy> getInsurancePolicies();
    InsurancePolicy create(InsurancePolicy dto);
    InsurancePolicy update(InsurancePolicy dto);
    void delete(Long id);
    Optional<InsurancePolicy> findById(Long id);
    List<InsurancePolicy> getInsurancePoliciesByInsuranceTypeTag(String tag);
}
