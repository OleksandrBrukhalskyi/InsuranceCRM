package com.insurance.crm.repository;

import com.insurance.crm.entity.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Agent,Long> {
}
