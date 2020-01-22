package com.insurance.crm.security.service;

import com.insurance.crm.constant.ErrorMessage;
import com.insurance.crm.entity.Agent;
import com.insurance.crm.exception.NotFoundException;
import com.insurance.crm.repository.AgentRepository;
import com.insurance.crm.security.entity.AgentPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomAgentDetailsService implements UserDetailsService {

    @Autowired
    AgentRepository agentRepository;

    @Override
    public UserDetails loadUserByUsername(String loginOrEmail) throws UsernameNotFoundException {
        Agent agent = agentRepository.findByEmailOrUsername(loginOrEmail,loginOrEmail)
                .orElseThrow(()-> new NotFoundException("User not found with username or email : " + loginOrEmail));
        return AgentPrincipal.create(agent);
    }
    @Transactional
    public UserDetails loadAgentById(Long id){
        Agent agent = agentRepository.findById(id)
                .orElseThrow(()-> new NotFoundException(ErrorMessage.AGENT_NOT_FOUND_BY_ID + id));
        return AgentPrincipal.create(agent);
    }
}
