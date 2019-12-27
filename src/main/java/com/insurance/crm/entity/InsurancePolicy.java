package com.insurance.crm.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InsurancePolicy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "sign_date",nullable = false,length = 10)
    private String signDate;
    @Column(name = "expiry_date",nullable = false,length = 10)
    private String expiryDate;
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "filiation_id",nullable = false)
    private Filiation filiation;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private InsuranceType insuranceType;
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "agent_id",nullable = false)
    private Agent agent;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id",nullable = false)
    private Customer customer;


}
