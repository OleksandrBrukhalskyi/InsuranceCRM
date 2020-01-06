package com.insurance.crm.dto.policy;

import com.insurance.crm.dto.agent.AgentRegistrationDto;
import com.insurance.crm.dto.customer.CustomerDto;
import com.insurance.crm.dto.filiation.FiliationDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsurancePolicyCreationDto {

    private Long id;
    @NotBlank
    private String signDate;
    @NotBlank
    private String expiryDate;
    @NotBlank
    private FiliationDto filiationDto;
    @NotBlank
    private AgentRegistrationDto agentDto;
    @NotBlank
    private CustomerDto customerDto;
}
