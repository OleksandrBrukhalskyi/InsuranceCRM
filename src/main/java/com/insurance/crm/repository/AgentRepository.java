package com.insurance.crm.repository;

import com.insurance.crm.entity.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AgentRepository extends JpaRepository<Agent,Long> {
    Agent findAgentBySurname(String surname);
    Agent findAgentByEmail(String email);
    Optional<Agent> findByEmailOrUsername(String email, String username);
    Boolean existsByUsername(String username);

}
