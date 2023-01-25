package com.j3v1t0.springbootmicroserviceloancustomer.dto;

import com.j3v1t0.springbootmicroserviceloancustomer.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerDto {
    private Customer customer;

}
