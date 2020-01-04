package com.insurance.crm.service;

import com.insurance.crm.dto.agent.AgentRoleDto;
import com.insurance.crm.dto.agent.AgentStatusDto;
import com.insurance.crm.dto.agent.AgentUpdateDto;
import com.insurance.crm.dto.agent.RoleDto;
import com.insurance.crm.entity.Agent;
import com.insurance.crm.entity.enums.AgentStatus;
import com.insurance.crm.entity.enums.Role;

import java.util.List;

public interface AgentService {
    List<Agent> getAgents();
    Agent create(Agent agent);
    Agent update(AgentUpdateDto agent,Long id);
    void delete(Long id);
    Agent getById(Long id);
    Agent getByEmail(String email);
    Agent findByAgentSurname(String surname);
    AgentStatusDto updateStatus(Long id, AgentStatus agentStatus);
    RoleDto getRoles();
    AgentRoleDto updateRole(Long id, Role role);

}
