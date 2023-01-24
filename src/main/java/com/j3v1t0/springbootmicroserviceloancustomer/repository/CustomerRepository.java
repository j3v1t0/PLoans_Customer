package com.j3v1t0.springbootmicroserviceloancustomer.repository;

import com.j3v1t0.springbootmicroserviceloancustomer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
