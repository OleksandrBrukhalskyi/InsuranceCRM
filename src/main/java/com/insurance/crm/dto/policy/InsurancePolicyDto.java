package com.insurance.crm.dto.policy;

import com.insurance.crm.dto.filiation.FiliationDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsurancePolicyDto {
    private Long id;
    private String signDate;
    private String expiryDate;
    private FiliationDto filiationDto;

}
