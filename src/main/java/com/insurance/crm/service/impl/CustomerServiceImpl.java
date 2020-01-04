package com.insurance.crm.service.impl;

import com.insurance.crm.constant.LogMessage;
import com.insurance.crm.dto.customer.CustomerDto;
import com.insurance.crm.entity.Customer;
import com.insurance.crm.exception.BadIdException;
import com.insurance.crm.repository.CustomerRepository;
import com.insurance.crm.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.insurance.crm.constant.ErrorMessage.CUSTOMER_NOT_FOUND_BY_ID;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    ModelMapper modelMapper;

    @Override
    public List<CustomerDto> getCustomers() {
        log.info(LogMessage.IN_FIND_ALL);
        return modelMapper.map(customerRepository.findAll(), new TypeToken<List<CustomerDto>>(){

        }.getType());
    }

    @Override
    public Customer create(Customer customer) {
        log.info(LogMessage.IN_SAVE,customer);
        return customerRepository.save(customer);
    }

    @Override
    public Customer update(CustomerDto dto, Long id) {
        log.info(LogMessage.IN_UPDATE);
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
        log.info(LogMessage.IN_DELETE_BY_ID, id);
        customerRepository.deleteById(id);
    }

    @Override
    public Optional<Customer> getById(Long id) {
        log.info(LogMessage.IN_FIND_BY_ID, id);
        return customerRepository.findById(id);
    }

    @Override
    public Customer findByCustomerSurname(String surname) {
        log.info(LogMessage.IN_FIND_BY_SURNAME,surname);
        return customerRepository.findCustomerBySurname(surname);
    }
}
