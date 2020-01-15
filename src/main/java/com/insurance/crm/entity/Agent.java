package com.insurance.crm.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "surname", length = 20)
    private String surname;
    @Column(name="firstname", length = 20)
    private String firstname;
    @Column(name = "patronymic", length = 20)
    private String patronymic;
    @Column(name = "email", length = 50, unique = true)
    private String email;
    @Column(name = "username", length = 20)
    private String username;
    @Column(name = "password", length = 100)
    private String password;
    @Column(name = "age", length = 2)
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="user_roles",
    joinColumns = @JoinColumn(name = "agent_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
    @ManyToOne(cascade = CascadeType.ALL,optional = false)
    @JoinColumn(name = "filiation_id",nullable = false)
    private Filiation filiation;


    public Agent(String surname, String firstname, String patronymic, String email, String login, String password, Integer age, String role, String agentStatus, Filiation filiation) {
    }

    public Agent(Long id, String surname, String firstname, String patronymic, String email, String login, String password, Integer age, String role, String agentStatus, Filiation filiation) {
    }

    public Agent(String surname, String firstname, String patronymic, String email, String username, String password, Filiation filiation) {
    }
}
