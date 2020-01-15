package com.insurance.crm.service.impl;

import com.insurance.crm.constant.ErrorMessage;
import com.insurance.crm.constant.LogMessage;
import com.insurance.crm.entity.InsurancePolicy;
import com.insurance.crm.exception.NotDeletedException;
import com.insurance.crm.exception.NotFoundException;
import com.insurance.crm.repository.AgentRepository;
import com.insurance.crm.repository.InsurancePolicyRepository;
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
    public List<InsurancePolicy> getInsurancePolicies() {
        log.info(LogMessage.IN_FIND_ALL);
        return insurancePolicyRepository.findAll();
    }

    @Override
    public InsurancePolicy create(InsurancePolicy dto) {
        log.info(LogMessage.IN_SAVE,dto);
        return insurancePolicyRepository.save(dto);
    }

    @Override
    public InsurancePolicy update(InsurancePolicy dto,Long id) {
        log.info(LogMessage.IN_UPDATE,id);
        return insurancePolicyRepository.findById(id)
                .map(insurancePolicy -> {
                    insurancePolicy.setInsuranceType(dto.getInsuranceType());
                    insurancePolicy.setCustomer(dto.getCustomer());
                    insurancePolicy.setAgent(dto.getAgent());
                    return insurancePolicyRepository.save(insurancePolicy);
                })
          .orElseThrow(()-> new NotFoundException(ErrorMessage.INSURANCE_POLICY_NOT_FOUND_BY_ID + id));
    }



    @Override
    public void delete(Long id) {
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
    public List<InsurancePolicy> getInsurancePoliciesByInsuranceTypeTag(String tag) {
        return insurancePolicyRepository.findInsurancePolicyByInsuranceTypeTag(tag);
    }
}
