package com.insurance.crm.controller;

import com.insurance.crm.constant.ErrorMessage;
import com.insurance.crm.constant.HttpStatuses;
import com.insurance.crm.dto.filiation.FiliationDto;
import com.insurance.crm.exception.NotFoundException;
import com.insurance.crm.service.impl.FiliationServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/filiation")
@AllArgsConstructor
public class FiliationController {
    private FiliationServiceImpl filiationService;
    private ModelMapper modelMapper;

    @ApiOperation(value = "Create Filiation")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = HttpStatuses.OK),
            @ApiResponse(code = 303, message = HttpStatuses.SEE_OTHER),
            @ApiResponse(code = 400, message = HttpStatuses.BAD_REQUEST),
            @ApiResponse(code = 403, message = HttpStatuses.FORBIDDEN)
    })
    @PostMapping
    public ResponseEntity save(@Valid @RequestBody FiliationDto dto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(filiationService.create(dto));
    }
    @ApiOperation(value = "Update filiation")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = HttpStatuses.OK),
            @ApiResponse(code = 303, message = HttpStatuses.SEE_OTHER),
            @ApiResponse(code = 400, message = HttpStatuses.BAD_REQUEST),
            @ApiResponse(code = 403, message = HttpStatuses.FORBIDDEN)
    })
    @PutMapping("/{filiationId}")
    public ResponseEntity<FiliationDto> update(@Valid @RequestBody FiliationDto dto,
                                               @PathVariable Long filiationId){
        return ResponseEntity.status(HttpStatus.OK)
                .body(modelMapper.map(filiationService.update(dto,filiationId),FiliationDto.class));
    }
    @ApiOperation("Get all filiations")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = HttpStatuses.OK),
            @ApiResponse(code = 303, message = HttpStatuses.SEE_OTHER),
            @ApiResponse(code = 400, message = HttpStatuses.BAD_REQUEST),
            @ApiResponse(code = 403, message = HttpStatuses.FORBIDDEN)
    })
    @GetMapping
    public List<FiliationDto> getFiliations(){
        return filiationService.getFiliations();
    }
    @ApiOperation("Get Filiation by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = HttpStatuses.OK),
            @ApiResponse(code = 303, message = HttpStatuses.SEE_OTHER),
            @ApiResponse(code = 403, message = HttpStatuses.FORBIDDEN)
    })
    @GetMapping("/{id}")
    public FiliationDto getById(@PathVariable Long id){
        return filiationService.findById(id)
                .orElseThrow(()->new NotFoundException(ErrorMessage.FILIATION_NOT_FOUND_BY_ID + id));
    }
}
