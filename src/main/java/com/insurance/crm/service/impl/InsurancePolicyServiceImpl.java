package com.insurance.crm.service.impl;

import com.insurance.crm.dto.policy.InsurancePolicyUpdateDto;
import com.insurance.crm.entity.InsurancePolicy;
import com.insurance.crm.exception.BadIdException;
import com.insurance.crm.repository.InsurancePolicyRepository;
import com.insurance.crm.service.InsurancePolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.insurance.crm.constant.ErrorMessage.INSURANCE_POLICY_NOT_FOUND_BY_ID;

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
    public InsurancePolicy update(InsurancePolicyUpdateDto dto, Long id) {
        InsurancePolicy insurancePolicy = insurancePolicyRepository.findById(id)
                .orElseThrow(()-> new BadIdException(INSURANCE_POLICY_NOT_FOUND_BY_ID + id));
        insurancePolicy.setFiliation(dto.getFiliation());
        insurancePolicy.setAgent(dto.getAgent());
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
