package com.kitchen.bhojnalay.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "cloud_kitchen")
@Data
public class CloudKitchen {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private String cloudKitchenId;

    private String kitchenName;

    private String ownerName;

    private String phoneNo;

    private String email;

    private String address;

    private String area;

    private String city;

    private String division;

    private String state;

    private String country;

    private String pincode;

    private String gstNumber;

    private String foodLicenseNumber;

    private boolean active;
}