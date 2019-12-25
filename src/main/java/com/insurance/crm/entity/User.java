package com.insurance.crm.entity;

import com.insurance.crm.entity.enums.Role;
import com.insurance.crm.entity.enums.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 20)
    private String surname;
    @Column(nullable = false, length = 20)
    private String firstname;
    @Column(nullable = false, length = 20)
    private String patronymic;
    @Column(nullable = false, length = 50, unique = true)
    private String email;
    @Column(nullable = false, length = 20)
    private String login;
    @Column(nullable = false, length = 20)
    private String password;
    @Column(nullable = false, length = 2)
    private Integer age;
    @ElementCollection(targetClass = UserStatus.class,fetch = FetchType.EAGER)
    @Enumerated(value = EnumType.STRING)
    private UserStatus userStatus;
    @ElementCollection(targetClass = Role.class,fetch = FetchType.EAGER)
    @CollectionTable(name="user_role",joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;



}
