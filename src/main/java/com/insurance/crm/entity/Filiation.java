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
public class Filiation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 30)
    private String name;
    @Column(nullable = false,length = 30)
    private String address;
    @Column(nullable = false,length = 30)
    private String phone;
    @OneToMany(mappedBy = "filiation")
    private List<Agent> agents;
    @OneToMany(mappedBy = "filiation")
    private InsurancePolicy insurancePolicy;


}
