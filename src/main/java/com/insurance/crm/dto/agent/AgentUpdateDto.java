package com.insurance.crm.dto.agent;

import com.insurance.crm.dto.filiation.FiliationDto;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AgentUpdateDto {
    @NotBlank
    private String surname;
    @NotBlank
    private String firstname;
    @NotBlank
    private String patronymic;
    @NotBlank
    private String password;
    @NotBlank
    private Integer age;

    private FiliationDto filiationDto;
}
