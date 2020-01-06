package com.insurance.crm.dto.agent;

import com.insurance.crm.dto.filiation.FiliationDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgentRegistrationDto {

    private Long id;
    @NotBlank
    private String surname;
    @NotBlank
    private String firstname;
    @NotBlank
    private String patronymic;
    @NotBlank
    private String login;
    @NotBlank
    private String password;
    @NotBlank
    private String email;
    @NotBlank
    private Integer age;
    private FiliationDto filiationDto;
}
