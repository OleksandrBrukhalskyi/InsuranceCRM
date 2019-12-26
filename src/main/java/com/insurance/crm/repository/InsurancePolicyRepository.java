package com.insurance.crm.repository;

import com.insurance.crm.entity.InsurancePolicy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsurancePolicyRepository extends JpaRepository<InsurancePolicy,Long> {
    InsurancePolicy findInsurancePolicyBySignDate(String sign_date);
}
