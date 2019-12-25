package com.insurance.crm.repository;

import com.insurance.crm.entity.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentRepository extends JpaRepository<Agent,Long> {
    Agent findAgentBySurname(String surname);
}
