package com.insurance.crm.service;

import com.insurance.crm.dto.filiation.FiliationDto;
import com.insurance.crm.entity.Filiation;

import java.util.List;

public interface FiliationService {
    List getFiliations();
    Filiation create(FiliationDto filiation);
    Filiation update(FiliationDto filiation,Long id);
    void delete(Long id);
    FiliationDto findById(Long id);
}
