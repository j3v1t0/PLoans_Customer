package com.j3v1t0.springbootmicroserviceloancustomer.service;

import com.j3v1t0.springbootmicroserviceloancustomer.dto.CustomerDto;
import com.j3v1t0.springbootmicroserviceloancustomer.model.Customer;

import java.util.Optional;

public interface CustomerService {
    Customer saveCustomer(CustomerDto customerDto);

    Optional<Customer> findByIdentification(String identification);
}
