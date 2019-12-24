package com.insurance.crm.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table(name="customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 30)
    private String surname;
    @Column(nullable = false,length = 30)
    private String firstname;
    @Column(nullable = false,length = 30)
    private String patronymic;
    @Column(nullable = false,length = 30)
    private String homeAddress;
    @Column(nullable = false,length = 30)
    private String phoneNum;
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private InsurancePolicy insurancePolicy;


}
