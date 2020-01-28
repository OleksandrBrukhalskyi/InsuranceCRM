package com.insurance.crm.service.impl;

import com.insurance.crm.constant.ErrorMessage;
import com.insurance.crm.constant.LogMessage;
import com.insurance.crm.entity.InsurancePolicy;
import com.insurance.crm.exception.NotDeletedException;
import com.insurance.crm.exception.NotFoundException;
import com.insurance.crm.repository.AgentRepository;
import com.insurance.crm.repository.InsurancePolicyRepository;
import com.insurance.crm.security.entity.AgentPrincipal;
import com.insurance.crm.service.FiliationService;
import com.insurance.crm.service.InsurancePolicyService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class InsurancePolicyServiceImpl implements InsurancePolicyService {
    @Autowired
    InsurancePolicyRepository insurancePolicyRepository;
    private AgentRepository agentRepository;
    private FiliationService filiationService;

    @Override
    public List<InsurancePolicy> getInsurancePolicies(AgentPrincipal agentPrincipal) {
        log.info(LogMessage.IN_FIND_ALL);
        return insurancePolicyRepository.findAll();
    }

    @Override
    public InsurancePolicy create(InsurancePolicy insurancePolicy) {
        log.info(LogMessage.IN_SAVE,insurancePolicy);
        return insurancePolicyRepository.save(insurancePolicy);
    }

    @Override
    public InsurancePolicy update(InsurancePolicy insurancePolicy) {
        log.info(LogMessage.IN_UPDATE);
        return insurancePolicyRepository.save(insurancePolicy);
    }



    @Override
    public void delete(Long id,AgentPrincipal agentPrincipal) {
        log.info(LogMessage.IN_DELETE_BY_ID,id);
        if(!(insurancePolicyRepository.findById(id).isPresent())){
            throw new NotDeletedException(ErrorMessage.INSURANCE_POLICY_NOT_DELETED + id);
        }
        insurancePolicyRepository.deleteById(id);
    }

    @Override
    public Optional<InsurancePolicy> findById(Long id) {
        log.info(LogMessage.IN_FIND_BY_ID,id);
        return Optional.ofNullable(insurancePolicyRepository.findById(id))
                .orElseThrow(()->new NotFoundException(ErrorMessage.INSURANCE_POLICY_NOT_FOUND_BY_ID + id));
    }

    @Override
    public List<InsurancePolicy> getInsurancePoliciesByInsuranceTypeTag(String tag,AgentPrincipal agentPrincipal) {
        return insurancePolicyRepository.findInsurancePolicyByInsuranceTypeTag(tag);
    }
}
