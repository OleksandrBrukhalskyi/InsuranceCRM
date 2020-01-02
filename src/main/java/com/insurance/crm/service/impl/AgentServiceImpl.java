package com.insurance.crm.service.impl;

import com.insurance.crm.dto.agent.AgentRoleDto;
import com.insurance.crm.dto.agent.AgentStatusDto;
import com.insurance.crm.dto.agent.AgentUpdateDto;
import com.insurance.crm.dto.agent.RoleDto;
import com.insurance.crm.entity.Agent;
import com.insurance.crm.entity.enums.AgentStatus;
import com.insurance.crm.entity.enums.Role;
import com.insurance.crm.exception.BadIdException;
import com.insurance.crm.repository.AgentRepository;
import com.insurance.crm.service.AgentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.insurance.crm.constant.ErrorMessage.AGENT_NOT_FOUND_BY_ID;
@Service
@AllArgsConstructor
public class AgentServiceImpl implements AgentService {
    @Autowired
    AgentRepository agentRepository;
    private ModelMapper modelMapper;



    @Override
    public List<Agent> getAgents() {
        return agentRepository.findAll();
    }

    public Agent create(Agent agent){
        return agentRepository.save(agent);
    }

    @Override
    public Agent update(AgentUpdateDto dto,Long id) {
        Agent agent = agentRepository
                .findById(id)
                .orElseThrow(() -> new BadIdException(AGENT_NOT_FOUND_BY_ID + id));
        agent.setSurname(dto.getSurname());
        agent.setFirstname(dto.getFirstname());
        agent.setPatronymic(dto.getPatronymic());
        return null;
    }


    public void delete(Long id){
        agentRepository.deleteById(id);
    }

    @Override
    public Agent getById(Long id) {
        return agentRepository.findById(id)
                .orElseThrow(()-> new BadIdException(AGENT_NOT_FOUND_BY_ID + id));
    }

    @Override
    public Agent findByAgentSurname(String surname) {
        return agentRepository.findAgentBySurname(surname);
    }
    @Override
    public AgentStatusDto updateStatus(Long id, AgentStatus agentStatus){
        Agent agent = getById(id);
        agent.setAgentStatus(agentStatus);
        return modelMapper.map(agentRepository.save(agent),AgentStatusDto.class);
    }

    @Override
    public RoleDto getRoles() {
        return new RoleDto(Role.class.getEnumConstants());
    }

    @Override
    public AgentRoleDto updateRole(Long id, Role role) {
        return null;
    }

}
