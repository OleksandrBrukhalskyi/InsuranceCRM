package com.insurance.crm.dto.policy;

import com.insurance.crm.entity.Agent;
import com.insurance.crm.entity.Filiation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsurancePolicyUpdateDto {
    @NotBlank
    private Long id;
    @NotBlank
    private Filiation filiation;
    @NotBlank
    private Agent agent;
}
