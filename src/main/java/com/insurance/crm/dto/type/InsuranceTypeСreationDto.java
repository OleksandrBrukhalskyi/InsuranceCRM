package com.insurance.crm.dto.type;

import com.insurance.crm.dto.policy.InsurancePolicyCreationDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsuranceTypeСreationDto {

    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String tag;
    @NotBlank
    private Double sumInsured;
    @NotBlank
    private InsurancePolicyCreationDto insurancePolicyDto;
}
