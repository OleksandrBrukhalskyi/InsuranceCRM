package com.insurance.crm.service.impl;

import com.insurance.crm.constant.ErrorMessage;
import com.insurance.crm.constant.LogMessage;
import com.insurance.crm.entity.Agent;
import com.insurance.crm.entity.Role;
import com.insurance.crm.exception.NotDeletedException;
import com.insurance.crm.repository.AgentRepository;
import com.insurance.crm.repository.FiliationRepository;
import com.insurance.crm.repository.RoleRepository;
import com.insurance.crm.service.AgentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class AgentServiceImpl implements AgentService {
    @Autowired
    private AgentRepository agentRepository;
    @Autowired
    private FiliationRepository filiationRepository;
    @Autowired
    private RoleRepository roleRepository;


    @Override
    public List<Agent> getAgents() {
        return agentRepository.findAll();
    }
    public Agent create(Agent agent) {
        log.info(LogMessage.IN_SAVE,agent);
        return agentRepository.save(agent);

    }

    @Override
    public Agent update(Agent dto) {
        log.info(LogMessage.IN_UPDATE);
            return  agentRepository.save(dto);
    }


    public void delete(Long id){
        log.info(LogMessage.IN_DELETE_BY_ID,id);
        if(!(agentRepository.findById(id).isPresent())){
            throw new NotDeletedException(ErrorMessage.AGENT_NOT_DELETED);
        }
        agentRepository.deleteById(id);
    }


    @Override
    public Optional<Agent> getById(Long id) {
        log.info(LogMessage.IN_FIND_BY_ID,id);
        return agentRepository.findById(id);
    }

    @Override
    public Agent getByEmail(String email) {
        log.info(LogMessage.IN_FIND_BY_EMAIL,email);
        return agentRepository.findAgentByEmail(email);
    }

    @Override
    public Agent findByAgentSurname(String surname) {
        return agentRepository.findAgentBySurname(surname);
    }

    @Override
    public List<Role> getRoles() {
        log.info(LogMessage.IN_FIND_ALL);
        return roleRepository.findAll();
    }

}
