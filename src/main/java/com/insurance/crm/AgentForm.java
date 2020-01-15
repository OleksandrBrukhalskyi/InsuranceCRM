package com.insurance.crm;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AgentForm {
    private Long id;
    private String surname;
    private String firstname;
    private String patronymic;
    private String username;
    private String login;
    private String password;
    private String role;
    private Long filiation;
}
