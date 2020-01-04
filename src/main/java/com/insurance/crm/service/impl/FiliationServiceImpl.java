package com.insurance.crm.service.impl;

import com.insurance.crm.constant.ErrorMessage;
import com.insurance.crm.constant.LogMessage;
import com.insurance.crm.dto.filiation.FiliationDto;
import com.insurance.crm.entity.Filiation;
import com.insurance.crm.exception.NotDeletedException;
import com.insurance.crm.exception.NotFoundException;
import com.insurance.crm.repository.FiliationRepository;
import com.insurance.crm.service.FiliationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class FiliationServiceImpl implements FiliationService {
    @Autowired
    FiliationRepository filiationRepository;
    private ModelMapper modelMapper;

    @Override
    public List<FiliationDto> getFiliations() {
        log.info(LogMessage.IN_FIND_ALL);
        return modelMapper.map(filiationRepository.findAll(), new TypeToken<List<FiliationDto>>(){
        }.getType());
    }

    @Override
    public Filiation create(FiliationDto dto) {
        log.info(LogMessage.IN_SAVE);
        return filiationRepository.save(modelMapper.map(dto,Filiation.class));
    }

    @Override
    public Filiation update(FiliationDto dto, Long id) {
        return filiationRepository.findById(id)
                .map(filiation -> {
                    filiation.setName(dto.getName());
                    filiation.setAddress(dto.getAddress());
                    filiation.setPhone(dto.getPhone());
                    return filiationRepository.save(filiation);
                })
        .orElseThrow(()-> new NotFoundException(ErrorMessage.FILIATION_NOT_FOUND_BY_ID + id));
    }



    @Override
    public void delete(Long id) {
        if(!(filiationRepository.findById(id).isPresent())){
            throw new NotDeletedException(ErrorMessage.FILIATION_NOT_DELETED);
        }
        filiationRepository.deleteById(id);
    }

    @Override
    public Optional<Filiation> findById(Long id) {
        return Optional.ofNullable(filiationRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ErrorMessage.FILIATION_NOT_FOUND_BY_ID + id)));
    }
}
