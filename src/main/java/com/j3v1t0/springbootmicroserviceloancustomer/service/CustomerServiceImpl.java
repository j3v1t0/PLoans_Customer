package com.j3v1t0.springbootmicroserviceloancustomer.service;

import com.j3v1t0.springbootmicroserviceloancustomer.dto.CustomerDto;
import com.j3v1t0.springbootmicroserviceloancustomer.model.Customer;
import com.j3v1t0.springbootmicroserviceloancustomer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer saveCustomer(CustomerDto customerDto){

        var customerId = UUID.randomUUID().toString();

        customerDto.getCustomer().setCustomerUuid(customerId);
        customerDto.getCustomer().setDateCreated(LocalDateTime.now());

        Customer customerCreated = customerRepository.save(customerDto.getCustomer());

        return customerCreated;

    }

    @Override
    public Optional<Customer> findByIdentification(String identification){
        return customerRepository.findByIdentification(identification);
    }
}
