package com.insurance.crm.controller;

import com.insurance.crm.constant.ErrorMessage;
import com.insurance.crm.constant.HttpStatuses;
import com.insurance.crm.dto.customer.CustomerDto;
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
import java.util.List;

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
    public ResponseEntity save(@Valid @RequestBody CustomerDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.create(dto));
    }
    @ApiOperation(value = "Get customer by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = HttpStatuses.OK),
            @ApiResponse(code = 303, message = HttpStatuses.SEE_OTHER),
            @ApiResponse(code = 403, message = HttpStatuses.FORBIDDEN)
    })
    @GetMapping("/{customerId}")
    public Customer getById(@PathVariable Long customerId){
        return customerService.getById(customerId)
                .orElseThrow(()-> new BadIdException(ErrorMessage.CUSTOMER_NOT_FOUND_BY_ID + customerId));
    }
    @ApiOperation("Get all customers")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = HttpStatuses.OK),
            @ApiResponse(code = 303, message = HttpStatuses.SEE_OTHER),
            @ApiResponse(code = 400, message = HttpStatuses.BAD_REQUEST),
            @ApiResponse(code = 403, message = HttpStatuses.FORBIDDEN)
    })
    @GetMapping
    public List<CustomerDto> getAll(){
        return customerService.getCustomers();
    }
    @ApiOperation(value = "Update customer")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = HttpStatuses.OK),
            @ApiResponse(code = 303, message = HttpStatuses.SEE_OTHER),
            @ApiResponse(code = 400, message = HttpStatuses.BAD_REQUEST),
            @ApiResponse(code = 403, message = HttpStatuses.FORBIDDEN)
    })
    @PutMapping("/{customerId}")
    public ResponseEntity<CustomerDto> update(@Valid @RequestBody CustomerDto dto,
                                              @PathVariable Long customerId){
        return ResponseEntity.status(HttpStatus.OK)
                .body(modelMapper.map(customerService.update(dto,customerId),CustomerDto.class));
    }
    @ApiOperation(value = "Delete customer")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = HttpStatuses.OK),
            @ApiResponse(code = 303, message = HttpStatuses.SEE_OTHER),
            @ApiResponse(code = 400, message = HttpStatuses.BAD_REQUEST),
            @ApiResponse(code = 403, message = HttpStatuses.FORBIDDEN)
    })
    @DeleteMapping("/customerId")
    public ResponseEntity delete (@PathVariable Long customerId){
        customerService.delete(customerId);
        return ResponseEntity.ok().build();
    }



}
