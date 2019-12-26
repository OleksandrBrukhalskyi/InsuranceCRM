package com.insurance.crm.service;

import com.insurance.crm.entity.Filiation;

import java.util.List;
import java.util.Optional;

public interface FiliationService {
    List<Filiation> getFiliations();
    Filiation create(Filiation filiation);
    Filiation update(Filiation filiation);
    void delete(Long id);
    Optional<Filiation> findById(Long id);
}
