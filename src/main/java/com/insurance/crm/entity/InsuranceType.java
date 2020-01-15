package com.insurance.crm.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InsuranceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name",nullable = false,length = 40)
    private String name;
    @Column(name = "sum_insured",nullable = false,length = 15)
    private double sumInsured;
    @Column(name = "tag",nullable = false,length = 4)
    private String tag;


}
