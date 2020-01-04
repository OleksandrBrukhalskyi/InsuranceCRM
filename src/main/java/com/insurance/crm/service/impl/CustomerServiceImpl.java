package com.insurance.crm.service.impl;

import com.insurance.crm.dto.customer.CustomerDto;
import com.insurance.crm.entity.Customer;
import com.insurance.crm.exception.BadIdException;
import com.insurance.crm.repository.CustomerRepository;
import com.insurance.crm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.insurance.crm.constant.ErrorMessage.CUSTOMER_NOT_FOUND_BY_ID;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer update(CustomerDto dto, Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(()-> new BadIdException(CUSTOMER_NOT_FOUND_BY_ID + id));
        customer.setSurname(dto.getSurname());
        customer.setFirstname(dto.getFirstname());
        customer.setPatronymic(dto.getPatronymic());
        customer.setHomeAddress(dto.getHomeAddress());
        customer.setPhoneNum(dto.getHomeNumber());
        customer.setAge(dto.getAge());
        return customerRepository.save(customer);
    }



    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Optional<Customer> getById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customer findByCustomerSurname(String surname) {
        return customerRepository.findCustomerBySurname(surname);
    }
}
