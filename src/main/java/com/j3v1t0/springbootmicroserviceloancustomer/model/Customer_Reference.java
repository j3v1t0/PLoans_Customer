package com.j3v1t0.springbootmicroserviceloancustomer.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "CUSTOMERREFERENCE")
public class Customer_Reference {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String customerReferenceUuid;
    private Long year;
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "reference_generator")
    @SequenceGenerator(name="reference_generator", sequenceName = "referencecustomer_seq",
                    initialValue = 1)
    private String customerReference;

}
