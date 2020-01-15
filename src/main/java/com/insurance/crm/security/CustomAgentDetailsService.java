package com.insurance.crm.security;

import com.insurance.crm.constant.ErrorMessage;
import com.insurance.crm.entity.Agent;
import com.insurance.crm.exception.NotFoundException;
import com.insurance.crm.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CustomAgentDetailsService implements UserDetailsService {

    @Autowired
    AgentRepository agentRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String loginOrEmail) throws UsernameNotFoundException {
        Agent agent = agentRepository.findByEmailOrUsername(loginOrEmail,loginOrEmail)
                .orElseThrow(()-> new NotFoundException("User not found with username or email : " + loginOrEmail));
        return AgentPrincipal.create(agent);
    }
    public UserDetails loadAgentById(Long id){
        Agent agent = agentRepository.findById(id)
                .orElseThrow(()-> new NotFoundException(ErrorMessage.AGENT_NOT_FOUND_BY_ID + id));
        return AgentPrincipal.create(agent);
    }
}
