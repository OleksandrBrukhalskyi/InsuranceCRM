package com.insurance.crm.repository;

import com.insurance.crm.entity.InsuranceType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceTypeRepository extends JpaRepository<InsuranceType,Long> {
}
