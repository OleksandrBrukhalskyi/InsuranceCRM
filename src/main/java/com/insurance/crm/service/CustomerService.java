package com.insurance.crm.service;


import com.insurance.crm.dto.customer.CustomerDto;
import com.insurance.crm.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List getCustomers();
    Customer create(CustomerDto customer);
    Customer update(CustomerDto customer,Long id);
    void delete(Long id);
    Optional<Customer> getById(Long id);
    Customer findByCustomerSurname(String surname);
}
