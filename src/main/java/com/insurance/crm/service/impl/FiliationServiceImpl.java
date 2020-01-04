package com.insurance.crm.service.impl;

import com.insurance.crm.dto.filiation.FiliationDto;
import com.insurance.crm.entity.Filiation;
import com.insurance.crm.exception.BadIdException;
import com.insurance.crm.repository.FiliationRepository;
import com.insurance.crm.service.FiliationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.insurance.crm.constant.ErrorMessage.FILIATION_NOT_FOUND_BY_ID;

@Service
public class FiliationServiceImpl implements FiliationService {
    @Autowired
    FiliationRepository filiationRepository;

    @Override
    public List<Filiation> getFiliations() {
        return filiationRepository.findAll();
    }

    @Override
    public Filiation create(Filiation filiation) {
        return filiationRepository.save(filiation);
    }

    @Override
    public Filiation update(FiliationDto dto, Long id) {
        Filiation filiation = filiationRepository.findById(id)
                .orElseThrow(()-> new BadIdException(FILIATION_NOT_FOUND_BY_ID + id));
        filiation.setName(dto.getName());
        filiation.setAddress(dto.getAddress());
        filiation.setPhone(dto.getPhone());
        return filiationRepository.save(filiation);
    }



    @Override
    public void delete(Long id) {
        filiationRepository.deleteById(id);
    }

    @Override
    public Optional<Filiation> findById(Long id) {
        return filiationRepository.findById(id);
    }
}
