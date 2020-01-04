package com.insurance.crm.controller;

import com.insurance.crm.constant.ErrorMessage;
import com.insurance.crm.constant.HttpStatuses;
import com.insurance.crm.entity.Customer;
import com.insurance.crm.exception.BadIdException;
import com.insurance.crm.service.CustomerService;
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

@RestController
@AllArgsConstructor
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    private ModelMapper modelMapper;

    @ApiOperation(value = "Save customer")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = HttpStatuses.OK),
            @ApiResponse(code = 303, message = HttpStatuses.SEE_OTHER),
            @ApiResponse(code = 403, message = HttpStatuses.FORBIDDEN),
    })
    @PostMapping
    public ResponseEntity save(@Valid @RequestBody Customer customer){
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.create(customer));
    }
    @ApiOperation(value = "Get customer by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = HttpStatuses.OK),
            @ApiResponse(code = 303, message = HttpStatuses.SEE_OTHER),
            @ApiResponse(code = 403, message = HttpStatuses.FORBIDDEN)
    })
    @GetMapping("/{customer_id}")
    public Customer getById(@PathVariable Long id){
        return customerService.getById(id)
                .orElseThrow(()-> new BadIdException(ErrorMessage.CUSTOMER_NOT_FOUND_BY_ID + id));
    }
//    @GetMapping
//    public CustomerDto getAll(){
//        return customerService.getCustomers();
//    }


}
