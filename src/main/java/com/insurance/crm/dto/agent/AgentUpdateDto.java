package com.insurance.crm.dto.agent;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AgentUpdateDto {
    @NotBlank
    private String surname;
    @NotBlank
    private String firstname;
    @NotBlank
    private String lastname;
    @NotBlank
    private Integer age;
}
