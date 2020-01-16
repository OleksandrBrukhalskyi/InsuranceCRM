package com.insurance.crm;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class InsurancePolicyForm {
    private String id;
    private LocalDate signDate;
    private String expiryDate;
    private String customer;
    private String agent;
    private String insuranceType;
}
