package com.insurance.crm.security.controller;

import com.insurance.crm.entity.Agent;
import com.insurance.crm.entity.Filiation;
import com.insurance.crm.entity.Role;
import com.insurance.crm.entity.enums.RoleName;
import com.insurance.crm.exception.NotFoundException;
import com.insurance.crm.repository.AgentRepository;
import com.insurance.crm.repository.RoleRepository;
import com.insurance.crm.security.provider.JwtTokenProvider;
import com.insurance.crm.security.request.LoginRequest;
import com.insurance.crm.security.request.SignUpRequest;
import com.insurance.crm.security.response.ApiResponse;
import com.insurance.crm.security.response.JwtAuthenticationResponse;
import com.insurance.crm.service.FiliationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collections;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    AgentRepository agentRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    JwtTokenProvider jwtTokenProvider;
    @Autowired
    FiliationService filiationService;
    @Autowired
    RoleRepository roleRepository;
    @PostMapping("/signin")
    public ResponseEntity<?> signIn(@Valid @RequestBody LoginRequest loginRequest){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);


        String jwt = jwtTokenProvider.generateToken(authentication);
        System.out.println(jwt);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@Valid @RequestBody SignUpRequest signUpRequest){
        if(agentRepository.existsByUsername(signUpRequest.getUsername())){
            return new ResponseEntity(new ApiResponse(false,"Username is already taken"),
                    HttpStatus.BAD_REQUEST);
        }
        Filiation filiation =filiationService.findById(signUpRequest.getFiliation());
        Agent agent = new Agent();
        agent.setSurname(signUpRequest.getSurname());
        agent.setFirstname(signUpRequest.getFirstname());
        agent.setPatronymic(signUpRequest.getPatronymic());
        agent.setEmail( signUpRequest.getEmail() );
        agent.setUsername(signUpRequest.getUsername());
        agent.setFiliation( filiation );

        agent.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        Role agentRole = roleRepository.findByName(RoleName.USER)
                .orElseThrow(() -> new NotFoundException("User Role not set."));
        agent.setRoles(Collections.singleton(agentRole));
        Agent res = agentRepository.save(agent);
        return ResponseEntity.ok().body(res);
    }
}
