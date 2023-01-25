package com.j3v1t0.springbootmicroserviceloancustomer.controller;

import com.j3v1t0.springbootmicroserviceloancustomer.dto.CustomerDto;
import com.j3v1t0.springbootmicroserviceloancustomer.model.Customer;
import com.j3v1t0.springbootmicroserviceloancustomer.model.CustomerStatus;
import com.j3v1t0.springbootmicroserviceloancustomer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("api/customer")
public class CustomerController {

    private final Logger logger = Logger.getLogger(CustomerController.class.getName());
    @Autowired
    private CustomerService customerService;

    @PostMapping("save")
    public ResponseEntity<?> saveCustomer(@RequestBody CustomerDto customerDto){


        if(customerService.findByEmail(customerDto.getCustomer().getEmail()).isPresent()){
            return new ResponseEntity<>("Correo ya registrado", HttpStatus.CONFLICT);
        }

        if (customerService.findByIdentification(customerDto.getCustomer().getIdentification()).isPresent()) {
                return new ResponseEntity<>("Customer is already registered!", HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(customerService.saveCustomer(customerDto), HttpStatus.CREATED);


    }

    @GetMapping("findallcustomerlist")
    public ResponseEntity<?> getAllUsersDetails(){

        return ResponseEntity.ok(customerService.findAllCustomerList());
    }

    @PutMapping("change/{customer}/{customerStatus}")
    public ResponseEntity<?> changeStatus(@PathVariable Customer customer, @PathVariable CustomerStatus customerStatus){
        customerService.changeStatus(customerStatus, customer.getCustomerUuid());

        return ResponseEntity.ok(true);
    }
}
