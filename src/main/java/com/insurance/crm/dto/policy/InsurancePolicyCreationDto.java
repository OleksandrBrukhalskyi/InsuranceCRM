package com.insurance.crm.dto.policy;

import com.insurance.crm.dto.agent.AgentCreationDto;
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
    @NotBlank
    private Long id;
    @NotBlank
    private String signDate;
    @NotBlank
    private String expiryDate;
    @NotBlank
    private FiliationDto filiationDto;
    @NotBlank
    private AgentCreationDto agentDto;
    @NotBlank
    private CustomerDto customerDto;
}
