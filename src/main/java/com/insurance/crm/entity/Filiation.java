package com.insurance.crm.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@Builder
public class Filiation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name",nullable = false,length = 30)
    private String name;
    @Column(name = "address",nullable = false,length = 30)
    private String address;
    @Column(name = "phone",nullable = false,length = 30)
    private String phone;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "filiation")
    private List<Agent> agents;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "filiation")
    private List<InsurancePolicy> insurancePolicies;


}
