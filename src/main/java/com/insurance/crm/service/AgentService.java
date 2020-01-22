package com.insurance.crm.service;

import com.insurance.crm.entity.Agent;
import com.insurance.crm.entity.Role;

import java.util.List;

public interface AgentService {
    List<Agent> getAgents();
    Agent create(Agent agent);
    Agent update(Agent agent);
    void delete(Long id);
    Agent getById(Long id);
    Agent getByEmail(String email);
    Agent findByAgentSurname(String surname);
    List<Role> getRoles();

}
