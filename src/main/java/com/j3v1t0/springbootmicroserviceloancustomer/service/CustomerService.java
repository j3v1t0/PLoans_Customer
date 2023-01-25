package com.j3v1t0.springbootmicroserviceloancustomer.service;

import com.j3v1t0.springbootmicroserviceloancustomer.dto.CustomerDto;
import com.j3v1t0.springbootmicroserviceloancustomer.dto.CustomerListDto;
import com.j3v1t0.springbootmicroserviceloancustomer.model.Customer;
import com.j3v1t0.springbootmicroserviceloancustomer.model.CustomerStatus;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Customer saveCustomer(CustomerDto customerDto);

    Customer updateCustomer(@RequestBody CustomerDto newData, @PathVariable String customerUuid);

    Optional<Customer> findByIdentification(String identification);

    List<CustomerListDto> findAllCustomerList();

    Optional<Customer> findByEmail(String email);

    @Transactional
    void changeStatus(CustomerStatus customerStatus, String customerUuid);
}
