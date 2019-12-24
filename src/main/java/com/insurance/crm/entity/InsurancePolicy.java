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
    @ManyToOne(fetch = FetchType.LAZY)
    private Filiation filiation;
    @OneToOne(mappedBy = "insurance_policy",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private InsuranceType insuranceType;
    @ManyToOne(fetch = FetchType.LAZY)
    private Agent agent;
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;


}
