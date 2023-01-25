package com.j3v1t0.springbootmicroserviceloancustomer.convert;

import com.j3v1t0.springbootmicroserviceloancustomer.dto.CustomerListDto;
import com.j3v1t0.springbootmicroserviceloancustomer.model.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class CustomerConverter {
    public CustomerListDto entityToDto(Customer customer){
        ModelMapper mapper = new ModelMapper();
        CustomerListDto map = mapper.map(customer, CustomerListDto.class);
        return map;
    }

    public List<CustomerListDto> entityToDto(List<Customer> user){
        return user.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
    }
}
