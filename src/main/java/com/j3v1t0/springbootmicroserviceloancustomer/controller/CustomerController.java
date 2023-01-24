package com.j3v1t0.springbootmicroserviceloancustomer.controller;

import com.j3v1t0.springbootmicroserviceloancustomer.dto.CustomerDto;
import com.j3v1t0.springbootmicroserviceloancustomer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("save")
    public ResponseEntity<?> saveCustomer(@RequestBody CustomerDto customerDto){
        if(customerService.findByIdentification(customerDto.getCustomer().getIdentification()).isPresent()){
            return new ResponseEntity<>("Customer is already registered!", HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(customerService.saveCustomer(customerDto), HttpStatus.OK);

    }
}
