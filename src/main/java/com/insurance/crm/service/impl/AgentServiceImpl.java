package com.insurance.crm.service.impl;

import com.insurance.crm.entity.Agent;
import com.insurance.crm.repository.AgentRepository;
import com.insurance.crm.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AgentServiceImpl implements AgentService {
    @Autowired
    AgentRepository agentRepository;



    @Override
    public List<Agent> getAgents() {
        return agentRepository.findAll();
    }

    public Agent create(Agent agent){
        return agentRepository.save(agent);
    }
    public Agent update(Agent agent){
        return agentRepository.save(agent);
    }
    public void delete(Long id){
        agentRepository.deleteById(id);
    }

    @Override
    public Optional<Agent> getById(Long id) {
        return agentRepository.findById(id);
    }

    @Override
    public Agent findByAgentSurname(String surname) {
        return agentRepository.findAgentBySurname(surname);
    }

}
