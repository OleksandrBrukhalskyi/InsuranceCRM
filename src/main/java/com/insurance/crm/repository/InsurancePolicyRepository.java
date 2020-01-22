package com.insurance.crm.repository;

import com.insurance.crm.entity.InsurancePolicy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InsurancePolicyRepository extends JpaRepository<InsurancePolicy,Long> {
    InsurancePolicy findInsurancePolicyBySignDate(String signDate);
    List<InsurancePolicy> findInsurancePolicyByInsuranceTypeTag(String tag);
}
