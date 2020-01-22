package com.insurance.crm.controller;

import com.insurance.crm.constant.ErrorMessage;
import com.insurance.crm.constant.HttpStatuses;
import com.insurance.crm.entity.Agent;
import com.insurance.crm.entity.Customer;
import com.insurance.crm.entity.InsurancePolicy;
import com.insurance.crm.entity.InsuranceType;
import com.insurance.crm.exception.NotFoundException;
import com.insurance.crm.forms.InsurancePolicyForm;
import com.insurance.crm.security.entity.AgentPrincipal;
import com.insurance.crm.service.impl.AgentServiceImpl;
import com.insurance.crm.service.impl.CustomerServiceImpl;
import com.insurance.crm.service.impl.InsurancePolicyServiceImpl;
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

@RestController
@RequestMapping("/policy")
@AllArgsConstructor
public class InsurancePolicyController {
    @Autowired
    private InsurancePolicyServiceImpl insurancePolicyService;
    @Autowired
    private AgentServiceImpl agentService;
    @Autowired
    private CustomerServiceImpl customerService;
    @Autowired
    private InsuranceTypeServiceImpl insuranceTypeService;

    @ApiOperation(value = "Create InsurancePolicy")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = HttpStatuses.OK),
            @ApiResponse(code = 303, message = HttpStatuses.SEE_OTHER),
            @ApiResponse(code = 400, message = HttpStatuses.BAD_REQUEST),
            @ApiResponse(code = 403, message = HttpStatuses.FORBIDDEN)
    })
    @PostMapping("/add")
    public ResponseEntity save(@Valid @RequestBody InsurancePolicyForm form){
        Agent agent = agentService.getById(form.getAgent());
        Customer customer = customerService.getById(form.getCustomer());
        InsuranceType insuranceType = insuranceTypeService.findById(form.getInsuranceType());

        InsurancePolicy insurancePolicy = new InsurancePolicy();
        insurancePolicy.setSignDate(form.getSignDate());
        insurancePolicy.setExpiryDate(form.getExpiryDate());
        insurancePolicy.setInsuranceType(insuranceType);
        insurancePolicy.setAgent(agent);
        insurancePolicy.setCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(insurancePolicyService.create(insurancePolicy));
    }
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = HttpStatuses.OK),
            @ApiResponse(code = 303, message = HttpStatuses.SEE_OTHER),
            @ApiResponse(code = 400, message = HttpStatuses.BAD_REQUEST),
            @ApiResponse(code = 403, message = HttpStatuses.FORBIDDEN)
    })
    @ApiOperation(value = "Update InsurancePolicy")
    @PostMapping("/update")
    public ResponseEntity<InsurancePolicy> update(@Valid @RequestBody InsurancePolicyForm form){
        Agent agent = agentService.getById(form.getAgent());
        Customer customer = customerService.getById(form.getCustomer());
        InsuranceType insuranceType = insuranceTypeService.findById(form.getInsuranceType());
        InsurancePolicy insurancePolicy = new InsurancePolicy();
        insurancePolicy.setSignDate(form.getSignDate());
        insurancePolicy.setExpiryDate(form.getExpiryDate());
        insurancePolicy.setInsuranceType(insuranceType);
        insurancePolicy.setAgent(agent);
        insurancePolicy.setCustomer(customer);
        return ResponseEntity.status(HttpStatus.OK)
                .body(insurancePolicyService.update(insurancePolicy));
    }
    @ApiOperation(value = "Get all Policies")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = HttpStatuses.OK),
            @ApiResponse(code = 303, message = HttpStatuses.SEE_OTHER),
            @ApiResponse(code = 400, message = HttpStatuses.BAD_REQUEST),
            @ApiResponse(code = 403, message = HttpStatuses.FORBIDDEN)
    })
    @GetMapping
    public List<InsurancePolicy> getAllPolicies(AgentPrincipal agentPrincipal){
        return insurancePolicyService.getInsurancePolicies(agentPrincipal);
    }
    @ApiOperation("Get Policy by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = HttpStatuses.OK),
            @ApiResponse(code = 303, message = HttpStatuses.SEE_OTHER),
            @ApiResponse(code = 403, message = HttpStatuses.FORBIDDEN)
    })
    @GetMapping("/{id}")
    public InsurancePolicy getbyId(@PathVariable Long id,AgentPrincipal agentPrincipal){
        return insurancePolicyService.findById(id,agentPrincipal)
                .orElseThrow(()-> new NotFoundException(ErrorMessage.INSURANCE_POLICY_NOT_FOUND_BY_ID + id));
    }
    @ApiOperation(value = "Delete Policy")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = HttpStatuses.OK),
            @ApiResponse(code = 303, message = HttpStatuses.SEE_OTHER),
            @ApiResponse(code = 400, message = HttpStatuses.BAD_REQUEST),
            @ApiResponse(code = 403, message = HttpStatuses.FORBIDDEN)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id,AgentPrincipal agentPrincipal){
        insurancePolicyService.delete(id,agentPrincipal);
        return ResponseEntity.ok().build();
    }

}
