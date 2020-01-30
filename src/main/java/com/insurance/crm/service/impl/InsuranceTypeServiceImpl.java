package com.insurance.crm.service.impl;

import com.insurance.crm.constant.ErrorMessage;
import com.insurance.crm.constant.LogMessage;
import com.insurance.crm.entity.InsuranceType;
import com.insurance.crm.exception.NotFoundException;
import com.insurance.crm.repository.InsuranceTypeRepository;
import com.insurance.crm.service.InsuranceTypeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


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
    public InsuranceType update(InsuranceType insuranceType) {
        log.info(LogMessage.IN_UPDATE,insuranceType);
        return insuranceTypeRepository.save(insuranceType);
    }



    @Override
    public void delete(Long id) {
        log.info(LogMessage.IN_DELETE_BY_ID,id);
        insuranceTypeRepository.deleteById(id);
    }

    @Override
    public InsuranceType findById(Long id) {
        log.info(LogMessage.IN_FIND_BY_ID,id);
        return insuranceTypeRepository.findById(id)
                .orElseThrow(()-> new NotFoundException(ErrorMessage.INSURANCE_TYPE_NOT_FOUND_BY_ID + id));
    }

    @Override
    public List<InsuranceType> getInsuranceTypeByName(String name) {
        log.info(LogMessage.IN_FIND_BY_INSURANCE_TYPE_NAME,name);
        return insuranceTypeRepository.getInsuranceTypeByName(name);
    }
    public Map<Object, Long> getQuantOfContractsGroupedByName(){
        return  this.getInsuranceTypes().stream()
                .collect(Collectors.groupingBy(InsuranceType::getName,Collectors.counting()));
    }
}
