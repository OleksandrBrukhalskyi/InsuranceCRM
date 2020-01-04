package com.insurance.crm.service.impl;

import com.insurance.crm.dto.type.InsuranceTypeUpdateDto;
import com.insurance.crm.entity.InsuranceType;
import com.insurance.crm.exception.BadIdException;
import com.insurance.crm.repository.InsuranceTypeRepository;
import com.insurance.crm.service.InsuranceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.insurance.crm.constant.ErrorMessage.INSURANCE_POLICY_NOT_FOUND_BY_ID;

@Service
public class InsuranceTypeServiceImpl implements InsuranceTypeService {
    @Autowired
    InsuranceTypeRepository insuranceTypeRepository;

    @Override
    public List<InsuranceType> getInsuranceTypes() {
        return insuranceTypeRepository.findAll();
    }

    @Override
    public InsuranceType create(InsuranceType insuranceType) {
        return insuranceTypeRepository.save(insuranceType);
    }

    @Override
    public InsuranceType update(InsuranceTypeUpdateDto dto, Long id) {
        InsuranceType insuranceType = insuranceTypeRepository.findById(id)
                .orElseThrow(()-> new BadIdException(INSURANCE_POLICY_NOT_FOUND_BY_ID + id));
        insuranceType.setName(dto.getName());
        insuranceType.setTag(dto.getTag());
        insuranceType.setSumInsured(dto.getSumInsured());
        return insuranceTypeRepository.save(insuranceType);
    }



    @Override
    public void delete(Long id) {
        insuranceTypeRepository.deleteById(id);
    }

    @Override
    public Optional<InsuranceType> findById(Long id) {
        return insuranceTypeRepository.findById(id);
    }

    @Override
    public List<InsuranceType> getInsuranceTypeByName(String name) {
        return insuranceTypeRepository.getInsuranceTypeByName(name);
    }
}
