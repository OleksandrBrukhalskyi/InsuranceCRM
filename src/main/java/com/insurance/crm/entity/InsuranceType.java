package com.insurance.crm.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class InsuranceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 40)
    private String name;
    @Column(nullable = false,length = 15)
    private double sumInsured;
    @Column(nullable = false,length = 4)
    private String tag;
    @OneToOne(mappedBy = "insurance_type",cascade = CascadeType.ALL)
    private InsurancePolicy insurancePolicy;


}
