package com.insurance.crm.entity;

import lombok.*;

import javax.persistence.*;
import javax.xml.ws.BindingType;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class InsurancePolicy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 10)
    private String signDate;
    @Column(nullable = false,length = 10)
    private String expiryDate;
    @ManyToOne
    private Filiation filiation;
    @OneToOne
    private InsuranceType insuranceType;
    @ManyToOne
    private Agent agent;
    @ManyToOne
    private Customer customer;


}
