package com.insurance.crm.forms;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerForm {
    private String id;
    private String surname;
    private String firstname;
    private String patronymic;
    private String phoneNum;
    private String homeAddress;
    private Integer age;
}
