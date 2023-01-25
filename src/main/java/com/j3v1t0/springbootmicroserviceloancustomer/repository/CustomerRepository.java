package com.j3v1t0.springbootmicroserviceloancustomer.repository;

import com.j3v1t0.springbootmicroserviceloancustomer.model.Customer;
import com.j3v1t0.springbootmicroserviceloancustomer.model.CustomerStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, String> {

    Optional<Customer> findByIdentification(String identification);
    Customer findByCustomerUuid(String customerUuid);

    @Query(
            value = "SELECT coalesce(max(customer_reference), 0) FROM Customer",
            nativeQuery = true)
    Long findByMaxCustomerReference(Long customerReference);

    Optional<Customer> findByEmail(String email);

    @Modifying
    @Query("update Customer set customerStatus=:customerStatus where customerUuid=:customerUuid")
    void updateCustomerStatus(@Param("customerUuid") String customerUuid, @Param("customerStatus") CustomerStatus customerStatus);
}
