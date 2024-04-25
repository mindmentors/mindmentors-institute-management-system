package com.mmc.app.platform.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mmc.app.platform.entity.Staff;

import java.io.Serializable;

public class CreateStaffRequest implements Serializable {
    /**
     * Serial Version Id
     */
    private static final long serialVersionUID = 5577021807669558622L;

    private String firstName;

    private String middleName;

    private String lastName;

    private String email;

    private String phone;

    private Integer desigId;

    private String alternateContactNo;

    private String profilePicturePath;

    private String gender;

    private String dateOfBirth;

    private String joiningDate;

    private Integer reportingTo;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String district;
    private String state;

    private String country;

    private String password;

    private Double Salary;

    @JsonIgnore
    private Staff manager;


}
