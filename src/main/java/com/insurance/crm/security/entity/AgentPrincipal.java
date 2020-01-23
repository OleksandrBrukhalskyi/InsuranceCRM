package com.insurance.crm.security.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.insurance.crm.entity.Agent;
import com.insurance.crm.entity.Filiation;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor

public class AgentPrincipal implements UserDetails {
    private Long id;
    private String surname;
    private String firstname;
    private String patronymic;
    @JsonIgnore
    private String email;
    private String username;
    @JsonIgnore
    private String password;
    private transient Filiation filiation;
    private Collection<? extends GrantedAuthority> authorities;



    public static AgentPrincipal create(Agent agent){
        List<GrantedAuthority> authorities = agent.getRoles().stream().map(role ->
                new SimpleGrantedAuthority(role.getName().name())
        ).collect(Collectors.toList());
        return new AgentPrincipal(
                agent.getId(),
                agent.getSurname(),
                agent.getFirstname(),
                agent.getPatronymic(),
                agent.getEmail(),
                agent.getUsername(),
                agent.getPassword(),
                agent.getFiliation(),
                authorities

        );
    }


    @Override
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
