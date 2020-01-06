package com.insurance.crm.controller;

import com.insurance.crm.constant.ErrorMessage;
import com.insurance.crm.constant.HttpStatuses;
import com.insurance.crm.dto.type.InsuranceTypeUpdateDto;
import com.insurance.crm.dto.type.InsuranceTypeСreationDto;
import com.insurance.crm.entity.InsuranceType;
import com.insurance.crm.exception.NotFoundException;
import com.insurance.crm.service.impl.InsuranceTypeServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/type")
@AllArgsConstructor
public class InsuranceTypeController {
    @Autowired
    private InsuranceTypeServiceImpl insuranceTypeService;
    @Autowired
    private ModelMapper modelMapper;

    @ApiOperation(value = "Create InsuranceType")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = HttpStatuses.OK),
            @ApiResponse(code = 303, message = HttpStatuses.SEE_OTHER),
            @ApiResponse(code = 400, message = HttpStatuses.BAD_REQUEST),
            @ApiResponse(code = 403, message = HttpStatuses.FORBIDDEN)
    })
    @PostMapping
    public ResponseEntity save(@Valid @RequestBody InsuranceTypeСreationDto dto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(insuranceTypeService.create(dto));
    }
    @ApiOperation(value = "Update InsuranceType")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = HttpStatuses.OK),
            @ApiResponse(code = 303, message = HttpStatuses.SEE_OTHER),
            @ApiResponse(code = 400, message = HttpStatuses.BAD_REQUEST),
            @ApiResponse(code = 403, message = HttpStatuses.FORBIDDEN)
    })
    @PutMapping("/{id}")
    public ResponseEntity<InsuranceTypeUpdateDto> update(@Valid @RequestBody InsuranceTypeUpdateDto dto,
                                                         @PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(modelMapper.map(insuranceTypeService.update(dto,id),InsuranceTypeUpdateDto.class));
    }
    @ApiOperation(value = "Get all InsuranceTypes")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = HttpStatuses.OK),
            @ApiResponse(code = 303, message = HttpStatuses.SEE_OTHER),
            @ApiResponse(code = 400, message = HttpStatuses.BAD_REQUEST),
            @ApiResponse(code = 403, message = HttpStatuses.FORBIDDEN)
    })
    @GetMapping
    public List<InsuranceType> getInsuranceTypes(){
        return insuranceTypeService.getInsuranceTypes();
    }
    @ApiOperation("Get InsuranceType by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = HttpStatuses.OK),
            @ApiResponse(code = 303, message = HttpStatuses.SEE_OTHER),
            @ApiResponse(code = 403, message = HttpStatuses.FORBIDDEN)
    })
    @GetMapping("/{id}")
    public InsuranceType getById(@PathVariable Long id){
        return  insuranceTypeService.findById(id)
                .orElseThrow(()-> new NotFoundException(ErrorMessage.INSURANCE_TYPE_NOT_FOUND_BY_ID));
    }
    @ApiOperation(value = "Delete InsuranceType")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = HttpStatuses.OK),
            @ApiResponse(code = 303, message = HttpStatuses.SEE_OTHER),
            @ApiResponse(code = 400, message = HttpStatuses.BAD_REQUEST),
            @ApiResponse(code = 403, message = HttpStatuses.FORBIDDEN)
    })
    @DeleteMapping
    public ResponseEntity delete(@PathVariable Long id){
        insuranceTypeService.delete(id);
        return ResponseEntity.ok().build();
    }
}
