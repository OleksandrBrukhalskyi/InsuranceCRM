package com.insurance.crm.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table(name="customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "surname",nullable = false,length = 30)
    private String surname;
    @Column(name = "firstname",nullable = false,length = 30)
    private String firstname;
    @Column(name = "patronymic",nullable = true,length = 30)
    private String patronymic;
    @Column(name = "home_address",nullable = false,length = 30)
    private String homeAddress;
    @Column(name = "phone_num",nullable = false,length = 30)
    private String phoneNum;
    @OneToMany(cascade = CascadeType.ALL)
    private List<InsurancePolicy> insurancePolicies;


}
