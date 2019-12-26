package com.insurance.crm.service.impl;

import com.insurance.crm.entity.InsurancePolicy;
import com.insurance.crm.repository.InsurancePolicyRepository;
import com.insurance.crm.service.InsurancePolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InsurancePolicyServiceImpl implements InsurancePolicyService {
    @Autowired
    InsurancePolicyRepository insurancePolicyRepository;

    @Override
    public List<InsurancePolicy> getInsurancePolicies() {
        return insurancePolicyRepository.findAll();
    }

    @Override
    public InsurancePolicy create(InsurancePolicy insurancePolicy) {
        return insurancePolicyRepository.save(insurancePolicy);
    }

    @Override
    public InsurancePolicy update(InsurancePolicy insurancePolicy) {
        return insurancePolicyRepository.save(insurancePolicy);
    }

    @Override
    public void delete(Long id) {
        insurancePolicyRepository.deleteById(id);
    }

    @Override
    public Optional<InsurancePolicy> findById(Long id) {
        return insurancePolicyRepository.findById(id);
    }

    @Override
    public List<InsurancePolicy> getInsurancePoliciesByInsuranceTypeTag(String tag) {
        return null;
    }
}
