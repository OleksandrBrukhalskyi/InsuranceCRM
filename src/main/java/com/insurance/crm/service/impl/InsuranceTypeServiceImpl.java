package com.insurance.crm.service.impl;

import com.insurance.crm.constant.ErrorMessage;
import com.insurance.crm.constant.LogMessage;
import com.insurance.crm.entity.InsuranceType;
import com.insurance.crm.exception.BadIdException;
import com.insurance.crm.repository.InsuranceTypeRepository;
import com.insurance.crm.service.InsuranceTypeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@Service
@AllArgsConstructor
@Slf4j
public class InsuranceTypeServiceImpl implements InsuranceTypeService {
    @Autowired
    InsuranceTypeRepository insuranceTypeRepository;


    @Override
    public List<InsuranceType> getInsuranceTypes() {
        log.info(LogMessage.IN_FIND_ALL);
        return insuranceTypeRepository.findAll();

    }

    @Override
    public InsuranceType create(InsuranceType dto) {
        log.info(LogMessage.IN_SAVE,dto);
        return insuranceTypeRepository.save(dto);
    }

    @Override
    public InsuranceType update(InsuranceType dto, Long id) {
        log.info(LogMessage.IN_UPDATE,dto);
        InsuranceType insuranceType = insuranceTypeRepository.findById(id)
                .orElseThrow(()-> new BadIdException(ErrorMessage.INSURANCE_POLICY_NOT_FOUND_BY_ID + id));
        insuranceType.setName(dto.getName());
        insuranceType.setTag(dto.getTag());
        insuranceType.setSumInsured(dto.getSumInsured());
        return insuranceTypeRepository.save(insuranceType);
    }



    @Override
    public void delete(Long id) {
        log.info(LogMessage.IN_DELETE_BY_ID,id);
        insuranceTypeRepository.deleteById(id);
    }

    @Override
    public Optional<InsuranceType> findById(Long id) {
        log.info(LogMessage.IN_FIND_BY_ID,id);
        return insuranceTypeRepository.findById(id);
    }

    @Override
    public List<InsuranceType> getInsuranceTypeByName(String name) {
        log.info(LogMessage.IN_FIND_BY_INSURANCE_TYPE_NAME,name);
        return insuranceTypeRepository.getInsuranceTypeByName(name);
    }
}
