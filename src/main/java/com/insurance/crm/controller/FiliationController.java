package com.insurance.crm.controller;

import com.insurance.crm.service.impl.FiliationServiceImpl;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/filiation")
@AllArgsConstructor
public class FiliationController {
    private FiliationServiceImpl filiationService;
    private ModelMapper modelMapper;
}
