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
    @Column(length = 30)
    private String phoneNum;
    @Column(name = "age",nullable = false,length = 2)
    private Integer age;


}
