package com.insurance.crm.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@Builder
public class Filiation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "filiaiton_id")
    private Long filiationId;
    @Column(name = "name",nullable = false,length = 30)
    private String name;
    @Column(name = "address",nullable = false,length = 30)
    private String address;
    @Column(name = "phone",nullable = false,length = 150)
    private String phone;


}
