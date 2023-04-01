package com.shopme.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Column;
import java.util.Date;

@Builder
@ToString
@Getter
public class CustomerDto {

    private String firstname;
    private String lastname;
    private String fullname;
    private String email;
    private String password;
    private boolean enabled;
    private String phoneNumber;
    private Date createdTime;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String postalCode;
    private String countryId;

}
