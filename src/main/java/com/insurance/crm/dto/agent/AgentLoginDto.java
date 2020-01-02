package com.insurance.crm.dto.agent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgentLoginDto {
    @NotBlank
    private String login;
    @NotBlank
    private String password;
}
