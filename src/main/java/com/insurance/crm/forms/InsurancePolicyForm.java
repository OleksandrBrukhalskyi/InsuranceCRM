package com.insurance.crm.forms;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InsurancePolicyForm {
    private String id;
    private String signDate;
    private String expiryDate;
    private Long customer;
    private Long agent;
    private Long insuranceType;
}
