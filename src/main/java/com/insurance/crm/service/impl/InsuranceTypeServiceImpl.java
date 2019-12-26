package com.insurance.crm.service.impl;

import com.insurance.crm.entity.InsuranceType;
import com.insurance.crm.repository.InsuranceTypeRepository;
import com.insurance.crm.service.InsuranceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public InsuranceType update(InsuranceType insuranceType) {
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
