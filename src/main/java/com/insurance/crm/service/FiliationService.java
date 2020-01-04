package com.insurance.crm.service;

import com.insurance.crm.dto.filiation.FiliationDto;
import com.insurance.crm.entity.Filiation;

import java.util.List;
import java.util.Optional;

public interface FiliationService {
    List getFiliations();
    Filiation create(FiliationDto filiation);
    Filiation update(FiliationDto filiation,Long id);
    void delete(Long id);
    Optional<FiliationDto> findById(Long id);
}
