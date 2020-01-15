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
    @OneToOne(optional = false,cascade = CascadeType.ALL)
    @JoinColumn(name = "insurance_type_id")
    private InsuranceType insuranceType;
    @ManyToOne(cascade = CascadeType.ALL,optional = false)
    @JoinColumn(name = "agent_id")
    private Agent agent;
    @ManyToOne(cascade = CascadeType.ALL,optional = false)
    @JoinColumn(name = "customer_id")
    private Customer customer;


}
