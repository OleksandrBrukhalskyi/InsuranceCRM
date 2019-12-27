package com.insurance.crm.dto.type;

import com.insurance.crm.dto.policy.InsurancePolicyDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsuranceTypeDto {
    @NotBlank
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String tag;
    @NotBlank
    private Double sumInsured;
    @NotBlank
    private InsurancePolicyDto insurancePolicyDto;
}
