package com.insurance.crm.service;


import com.insurance.crm.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<Customer> getCustomers();
    Customer create(Customer customer);
    Customer update(Customer customer,Long id);
    void delete(Long id);
    Optional<Customer> getById(Long id);
    Customer findByCustomerSurname(String surname);
}
