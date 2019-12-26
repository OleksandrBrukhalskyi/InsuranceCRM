package com.insurance.crm.repository;

import com.insurance.crm.entity.InsuranceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InsuranceTypeRepository extends JpaRepository<InsuranceType,Long> {
    InsuranceType findByName(String name);
    List<InsuranceType> getInsuranceTypeByName(String name);
}
