package com.insurance.crm.service;

import com.insurance.crm.entity.InsurancePolicy;
import com.insurance.crm.security.entity.AgentPrincipal;

import java.util.List;
import java.util.Optional;

public interface InsurancePolicyService {
    List<InsurancePolicy> getInsurancePolicies(AgentPrincipal agentPrincipal);
    InsurancePolicy create(InsurancePolicy dto);
    InsurancePolicy update(InsurancePolicy dto);
    void delete(Long id,AgentPrincipal agentPrincipal);
    Optional<InsurancePolicy> findById(Long id);
    List<InsurancePolicy> getInsurancePoliciesByInsuranceTypeTag(String tag,AgentPrincipal agentPrincipal);
}
