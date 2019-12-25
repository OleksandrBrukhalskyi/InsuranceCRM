package com.insurance.crm.repository;

import com.insurance.crm.entity.InsurancePolicy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsurancePolicyRepository extends JpaRepository<InsurancePolicy,Long> {
}
