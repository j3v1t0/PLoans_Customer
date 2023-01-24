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
@Table(name = "PHONE")
public class Phone {

    @Id
    private String phoneId;
    @Enumerated(EnumType.STRING)
    private PhoneLabel phoneLabel;
    @Column(name = "number")
    private String number;
    @Column(name = "city_code")
    private String cityCode;
    @Column(name = "country_code")
    private String countryCode;

    public String getPhoneId() {
        var phoneId = UUID.randomUUID().toString();
        return phoneId;
    }
}
