package com.j3v1t0.springbootmicroserviceloancustomer.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    private String customerUuid;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customerReferenceUuid")
    private Customer_Reference customerReference;
    @Column(name = "customer_name", nullable = false, length = 100)
    private String customerName;
    @Column(name = "customer_lastname", nullable = false, length = 100)
    private String customerLastname;
    @Enumerated(EnumType.STRING)
    @Column(name = "identification_type", nullable = false, length = 15)
    private IdentificationType identificationType;
    @Column(name = "identification", nullable = false)
    private String identification;
    @Enumerated(EnumType.STRING)
    @Column(name = "sex", nullable = false, length = 8)
    private Sex sex;
    @Enumerated(EnumType.STRING)
    @Column(name = "civil_status", nullable = false, length = 15)
    private CivilStatus civilStatus;
    @OneToMany(targetEntity = Phone.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="customer_uuid",referencedColumnName = "customerUuid")
    private List<Phone> phoneList;
    @OneToMany(targetEntity = ResidenceDetails.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="customer_uuid",referencedColumnName = "customerUuid")
    private List<ResidenceDetails> residenceDetails;

    @Column(name = "date_created", nullable = false)
    private LocalDateTime dateCreated;
    @Enumerated(EnumType.STRING)
    @Column(name = "customer_status", nullable = false, length = 15)
    private CustomerStatus customerStatus;
}
