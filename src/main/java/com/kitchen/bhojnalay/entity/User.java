package com.kitchen.bhojnalay.entity;

import java.time.LocalDate;
import java.time.LocalTime;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String userName;

    @Column(unique = true)
    private String phoneNo;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;
    private String address;
    private String mealPreference;
    private String dietaryNeeds;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Transient
    private DurationType durationType;

    @Transient
    private LocalDate endDate;

    @Transient
    private LocalTime endTime;
    
    @ManyToOne
    @JoinColumn(name = "cloud_kitchen_id")
    private CloudKitchen cloudKitchen;
}