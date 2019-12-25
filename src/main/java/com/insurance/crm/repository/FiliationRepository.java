package com.insurance.crm.repository;

import com.insurance.crm.entity.Filiation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FiliationRepository extends JpaRepository<Filiation,Long> {
}

