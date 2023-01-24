package com.j3v1t0.springbootmicroserviceloancustomer.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "RESIDENCEDETAILS")
public class ResidenceDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String residenceUuid;
    @Enumerated(EnumType.STRING)
    @Column(name = "ownership_status")
    private OwnershipStatus ownershipStatus;
    @Column(name = "timeliving_years")
    private Long timeLivingYears;
    @Column(name = "timeliving_month")
    private Long timeLivingMonth;
    @Column(name = "address_customer")
    private String addressCustomer;
    @Column(name = "building_name")
    private String buildingName;
    @Column(name = "apartment_number")
    private String apartmentNumber;

}
