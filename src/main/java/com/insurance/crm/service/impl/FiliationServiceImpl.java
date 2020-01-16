package com.insurance.crm.service.impl;

import com.insurance.crm.constant.ErrorMessage;
import com.insurance.crm.constant.LogMessage;
import com.insurance.crm.entity.Filiation;
import com.insurance.crm.exception.NotDeletedException;
import com.insurance.crm.exception.NotFoundException;
import com.insurance.crm.repository.FiliationRepository;
import com.insurance.crm.service.FiliationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class FiliationServiceImpl implements FiliationService {
    @Autowired
    FiliationRepository filiationRepository;

    @Override
    public List<Filiation> getFiliations() {
        log.info(LogMessage.IN_FIND_ALL);
        return filiationRepository.findAll();
    }

    @Override
    public Filiation create(Filiation dto) {
        log.info(LogMessage.IN_SAVE);
        return filiationRepository.save(dto);
    }

    @Override
    public Filiation update(Filiation filiation) {
        return filiationRepository.save(filiation);

    }



    @Override
    public void delete(Long id) {
        if(!(filiationRepository.findById(id).isPresent())){
            throw new NotDeletedException(ErrorMessage.FILIATION_NOT_DELETED);
        }
        filiationRepository.deleteById(id);
    }

    @Override
    public Filiation findById(Long id) {
        return filiationRepository.findById(id)
                .orElseThrow(()-> new NotFoundException(ErrorMessage.FILIATION_NOT_FOUND_BY_ID + id));
    }
}
