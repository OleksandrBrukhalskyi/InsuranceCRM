package com.insurance.crm.dto.type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsuranceTypeUpdateDto {

    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String tag;
    @NotBlank
    private Double sumInsured;
}
