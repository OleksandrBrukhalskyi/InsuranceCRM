package com.insurance.crm.controller;

import com.insurance.crm.constant.HttpStatuses;
import com.insurance.crm.entity.InsuranceType;
import com.insurance.crm.forms.InsuranceTypeForm;
import com.insurance.crm.service.impl.InsuranceTypeServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/type")
@AllArgsConstructor
public class InsuranceTypeController {
    @Autowired
    private InsuranceTypeServiceImpl insuranceTypeService;

    @ApiOperation(value = "Create InsuranceType")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = HttpStatuses.OK),
            @ApiResponse(code = 303, message = HttpStatuses.SEE_OTHER),
            @ApiResponse(code = 400, message = HttpStatuses.BAD_REQUEST),
            @ApiResponse(code = 403, message = HttpStatuses.FORBIDDEN)
    })
     @PostMapping("/add")
    public ResponseEntity save(@Valid @RequestBody InsuranceTypeForm form){
        InsuranceType insuranceType = new InsuranceType();
        insuranceType.setName(form.getName());
        insuranceType.setTag(form.getTag());
        insuranceType.setSumInsured(form.getSumInsured());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(insuranceTypeService.create(insuranceType));
    }
    @ApiOperation(value = "Update InsuranceType")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = HttpStatuses.OK),
            @ApiResponse(code = 303, message = HttpStatuses.SEE_OTHER),
            @ApiResponse(code = 400, message = HttpStatuses.BAD_REQUEST),
            @ApiResponse(code = 403, message = HttpStatuses.FORBIDDEN)
    })
    @PutMapping("/{id}")
    public ResponseEntity<InsuranceType> update(@Valid @RequestBody InsuranceTypeForm form,@PathVariable("id") Long id){
        InsuranceType insuranceType = insuranceTypeService.findById(id);
        insuranceType.setName(form.getName());
        insuranceType.setTag(form.getTag());
        insuranceType.setSumInsured(form.getSumInsured());
        return ResponseEntity.status(HttpStatus.OK)
                .body(insuranceTypeService.update(insuranceType));
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
        return  insuranceTypeService.findById(id);
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
    @GetMapping("/quant")
    public Map<Object, Long> getQuantOfContractsGroupedByName(){
        return  this.insuranceTypeService.getQuantOfContractsGroupedByName();
    }
}
