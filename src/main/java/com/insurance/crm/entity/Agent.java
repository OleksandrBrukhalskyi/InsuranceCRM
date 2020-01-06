package com.insurance.crm.entity;

import com.insurance.crm.entity.enums.AgentStatus;
import com.insurance.crm.entity.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "agents")
public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "surname",nullable = false, length = 20)
    private String surname;
    @Column(name="firstname",nullable = false, length = 20)
    private String firstname;
    @Column(name = "patronymic",nullable = true, length = 20)
    private String patronymic;
    @Column(name = "email",nullable = true, length = 50, unique = true)
    private String email;
    @Column(name = "login",nullable = false, length = 20)
    private String login;
    @Column(name = "password",nullable = false, length = 20)
    private String password;
    @Column(name = "age",nullable = true, length = 2)
    private Integer age;
    @Enumerated(value = EnumType.STRING)
    private AgentStatus agentStatus;
    @ElementCollection(targetClass = Role.class,fetch = FetchType.EAGER)
    @CollectionTable(name="agent_role",joinColumns = @JoinColumn(name = "agent_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "filiation_id",nullable = false)
    private Filiation filiation;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "agent")
    private List<InsurancePolicy> insurancePolicies;



}
