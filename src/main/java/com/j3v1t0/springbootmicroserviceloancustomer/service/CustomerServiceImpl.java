package com.j3v1t0.springbootmicroserviceloancustomer.service;

import com.j3v1t0.springbootmicroserviceloancustomer.convert.CustomerConverter;
import com.j3v1t0.springbootmicroserviceloancustomer.dto.CustomerDto;
import com.j3v1t0.springbootmicroserviceloancustomer.dto.CustomerListDto;
import com.j3v1t0.springbootmicroserviceloancustomer.model.Customer;
import com.j3v1t0.springbootmicroserviceloancustomer.model.CustomerStatus;
import com.j3v1t0.springbootmicroserviceloancustomer.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

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

        var customerUuid = UUID.randomUUID().toString();

        Long findMaxCustomerReference = customerRepository.findByMaxCustomerReference(customerDto.getCustomer().getCustomerReference());

        if (findMaxCustomerReference == 0) {
            Long maxCustomerReferencePlusOne = findMaxCustomerReference + 1;
            String maxCustomerReference = String.valueOf(maxCustomerReferencePlusOne);

            String thisYear = String.valueOf((long) Year.now().getValue());

            String concatYearAndMaxCustomerReference = thisYear.concat(maxCustomerReference);

            customerDto.getCustomer().setCustomerUuid(customerUuid);
            customerDto.getCustomer().setDateCreated(LocalDateTime.now());
            customerDto.getCustomer().setCustomerReference(Long.valueOf(concatYearAndMaxCustomerReference));

            Customer customerCreated = customerRepository.save(customerDto.getCustomer());
            return customerCreated;
        }else {
            Long maxCustomerReferencePlusOne = findMaxCustomerReference + 1;
            String maxCustomerReference = String.valueOf(maxCustomerReferencePlusOne).substring(4);

            String thisYear = String.valueOf((long) Year.now().getValue());

            String concatYearAndMaxCustomerReference = thisYear.concat(maxCustomerReference);

            customerDto.getCustomer().setCustomerUuid(customerUuid);
            customerDto.getCustomer().setDateCreated(LocalDateTime.now());
            customerDto.getCustomer().setCustomerReference(Long.valueOf(concatYearAndMaxCustomerReference));

            Customer customerCreated = customerRepository.save(customerDto.getCustomer());
            return customerCreated;
        }

    }

    @Override
    public Customer updateCustomer(@RequestBody CustomerDto newData, @PathVariable String customerUuid){
        return customerRepository.findById(customerUuid)
                .map(customer -> {
                    customer.setCustomerName(newData.getCustomer().getCustomerName());
                    customer.setCustomerLastname(newData.getCustomer().getCustomerLastname());
                    customer.setEmail(newData.getCustomer().getEmail());
                    customer.setIdentificationType(newData.getCustomer().getIdentificationType());
                    customer.setIdentification(newData.getCustomer().getIdentification());
                    customer.setSex(newData.getCustomer().getSex());
                    customer.setCivilStatus(newData.getCustomer().getCivilStatus());
                    customer.setPhoneList(newData.getCustomer().getPhoneList());
                    customer.setResidenceDetails(newData.getCustomer().getResidenceDetails());
                    customer.setDateUpdated(LocalDateTime.now());
                    customer.setCustomerStatus(newData.getCustomer().getCustomerStatus());
                    return customerRepository.save(customer);
                }).orElseThrow(()->new UsernameNotFoundException(customerUuid));

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
