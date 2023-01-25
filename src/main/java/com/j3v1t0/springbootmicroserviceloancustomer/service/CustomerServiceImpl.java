package com.j3v1t0.springbootmicroserviceloancustomer.service;

import com.j3v1t0.springbootmicroserviceloancustomer.convert.CustomerConverter;
import com.j3v1t0.springbootmicroserviceloancustomer.dto.CustomerDto;
import com.j3v1t0.springbootmicroserviceloancustomer.dto.CustomerListDto;
import com.j3v1t0.springbootmicroserviceloancustomer.model.Customer;
import com.j3v1t0.springbootmicroserviceloancustomer.model.CustomerStatus;
import com.j3v1t0.springbootmicroserviceloancustomer.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.Year;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    CustomerConverter customerConverter;

    @Override
    public Customer saveCustomer(CustomerDto customerDto){

        var customerId = UUID.randomUUID().toString();

        Long findMaxCustomerReference = customerRepository.findByMaxCustomerReference(customerDto.getCustomer().getCustomerReference());

        String thisYear = String.valueOf((long) Year.now().getValue());

        String maxCustomerReference = String.valueOf(findMaxCustomerReference);

        String concatYearAndMaxCustomerReference = thisYear.concat(maxCustomerReference);

        customerDto.getCustomer().setCustomerUuid(customerId);
        customerDto.getCustomer().setDateCreated(LocalDateTime.now());
        customerDto.getCustomer().setCustomerReference(Long.valueOf(concatYearAndMaxCustomerReference));

        Customer customerCreated = customerRepository.save(customerDto.getCustomer());

        return customerCreated;

    }

    @Override
    public Optional<Customer> findByIdentification(String identification){
        return customerRepository.findByIdentification(identification);
    }

    @Override
    public List<CustomerListDto> findAllCustomerList(){
        List<Customer> findAll = customerRepository.findAll();

        return customerConverter.entityToDto(findAll);

    }

    @Override
    public Optional<Customer> findByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    @Transactional
    @Override
    public void changeStatus(CustomerStatus customerStatus, String customerUuid){
        customerRepository.updateCustomerStatus(customerUuid, customerStatus);
    }
}
