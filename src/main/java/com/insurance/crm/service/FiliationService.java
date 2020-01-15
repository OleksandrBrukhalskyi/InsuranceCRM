package com.insurance.crm.service;

import com.insurance.crm.entity.Filiation;

import java.util.List;

public interface FiliationService {
    List<Filiation> getFiliations();
    Filiation create(Filiation filiation);
    Filiation update(Filiation filiation,Long id);
    void delete(Long id);
    Filiation findById(Long id);
}
