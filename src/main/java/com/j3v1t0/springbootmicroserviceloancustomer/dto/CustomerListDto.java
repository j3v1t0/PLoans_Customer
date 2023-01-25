package com.j3v1t0.springbootmicroserviceloancustomer.dto;

import com.j3v1t0.springbootmicroserviceloancustomer.model.CustomerStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerListDto {

    private Long customerReference;
    private String customerName;

    private String customerLastname;
    private String identification;

    private String email;

    private CustomerStatus customerStatus;

    private LocalDateTime dateCreated;

}
