package com.insurance.crm.controller;

import com.insurance.crm.constant.HttpStatuses;
import com.insurance.crm.entity.Filiation;
import com.insurance.crm.forms.FiliationForm;
import com.insurance.crm.service.impl.FiliationServiceImpl;
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

@RestController
@RequestMapping("/filiation")
@AllArgsConstructor
public class FiliationController {
    @Autowired
    private FiliationServiceImpl filiationService;

    @ApiOperation(value = "Create Filiation")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = HttpStatuses.OK),
            @ApiResponse(code = 303, message = HttpStatuses.SEE_OTHER),
            @ApiResponse(code = 400, message = HttpStatuses.BAD_REQUEST),
            @ApiResponse(code = 403, message = HttpStatuses.FORBIDDEN)
    })
    @PostMapping("/add")
    public ResponseEntity save(@Valid @RequestBody FiliationForm form){
        Filiation filiation = new Filiation();
        filiation.setName(form.getName());
        filiation.setAddress(form.getAddress());
        filiation.setPhone(form.getPhone());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(filiationService.create(filiation));
    }
    @ApiOperation(value = "Update filiation")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = HttpStatuses.OK),
            @ApiResponse(code = 303, message = HttpStatuses.SEE_OTHER),
            @ApiResponse(code = 400, message = HttpStatuses.BAD_REQUEST),
            @ApiResponse(code = 403, message = HttpStatuses.FORBIDDEN)
    })
    @PutMapping("/{id}")
    public ResponseEntity<Filiation> update(@Valid @RequestBody FiliationForm form, @PathVariable("id") Long id){
        Filiation filiation = filiationService.findById(id);
        filiation.setName(form.getName());
        filiation.setAddress(form.getAddress());
        filiation.setPhone(form.getPhone());
        return ResponseEntity.status(HttpStatus.OK)
                .body(filiationService.update(filiation));
    }
    @ApiOperation("Get all filiations")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = HttpStatuses.OK),
            @ApiResponse(code = 303, message = HttpStatuses.SEE_OTHER),
            @ApiResponse(code = 400, message = HttpStatuses.BAD_REQUEST),
            @ApiResponse(code = 403, message = HttpStatuses.FORBIDDEN)
    })
    @GetMapping
    public List<Filiation> getFiliations(){
        return filiationService.getFiliations();
    }

    @ApiOperation("Get Filiation by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = HttpStatuses.OK),
            @ApiResponse(code = 303, message = HttpStatuses.SEE_OTHER),
            @ApiResponse(code = 403, message = HttpStatuses.FORBIDDEN)
    })
    @GetMapping("/{id}")
    public Filiation getById(@PathVariable Long id){
        return filiationService.findById(id);
    }
    @ApiOperation(value = "Delete filiation")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = HttpStatuses.OK),
            @ApiResponse(code = 303, message = HttpStatuses.SEE_OTHER),
            @ApiResponse(code = 400, message = HttpStatuses.BAD_REQUEST),
            @ApiResponse(code = 403, message = HttpStatuses.FORBIDDEN)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        filiationService.delete(id);
        return ResponseEntity.ok().build();
    }
}
