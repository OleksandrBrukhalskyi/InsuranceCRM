package com.insurance.crm.service;

import com.insurance.crm.entity.InsuranceType;

import java.util.List;

public interface InsuranceTypeService {
    List<InsuranceType> getInsuranceTypes();
    InsuranceType create(InsuranceType dto);
    InsuranceType update(InsuranceType dto);
    void delete(Long id);
    InsuranceType findById(Long id);
    List<InsuranceType> getInsuranceTypeByName(String name);

}
