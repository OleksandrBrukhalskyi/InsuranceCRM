package com.insurance.crm.service;

import com.insurance.crm.entity.InsuranceType;

import java.util.List;
import java.util.Optional;

public interface InsuranceTypeService {
    List<InsuranceType> getInsuranceTypes();
    InsuranceType create(InsuranceType insuranceType);
    InsuranceType update(InsuranceType insuranceType);
    void delete(Long id);
    Optional<InsuranceType> findById(Long id);
    List<InsuranceType> getInsuranceTypeByName(String name);

}
