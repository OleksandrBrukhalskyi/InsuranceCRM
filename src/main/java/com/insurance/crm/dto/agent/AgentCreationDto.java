package com.insurance.crm.dto.agent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgentCreationDto {
    @NotBlank
    private Long id;
    @NotBlank
    private String surname;
    @NotBlank
    private String firstname;
    @NotBlank
    private String patronymic;
    @NotBlank
    private String email;
    @NotBlank
    private Integer age;
}
