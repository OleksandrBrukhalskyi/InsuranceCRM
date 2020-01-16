package com.insurance.crm;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerForm {
    private String id;
    private String surname;
    private String firstname;
    private String patronymic;
    private String phone;
    private String address;
}
