package com.insurance.crm.service.impl;

import com.insurance.crm.entity.Agent;
import com.insurance.crm.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AgentServiceImpl {
    @Autowired
    AgentService agentService;

    public List<Agent> findAllAgents(){
        return agentService.getAgents();
    }

}
