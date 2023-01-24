package com.j3v1t0.springbootmicroserviceloancustomer.service;

import com.j3v1t0.springbootmicroserviceloancustomer.dto.CustomerDto;
import com.j3v1t0.springbootmicroserviceloancustomer.model.Customer;
import com.j3v1t0.springbootmicroserviceloancustomer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    public Customer saveCustomer(CustomerDto customerDto){

        var customerId = UUID.randomUUID().toString();

        customerDto.getCustomer().setUuid(customerId);
        customerDto.getCustomer().setFechaCreacion(LocalDateTime.now());

        Customer customerCreated = customerRepository.save(customerDto.getCustomer());

        return customerCreated;

    }
}
