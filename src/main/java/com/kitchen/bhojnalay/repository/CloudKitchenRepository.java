package com.kitchen.bhojnalay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kitchen.bhojnalay.entity.CloudKitchen;

@Repository
public interface CloudKitchenRepository extends JpaRepository<CloudKitchen, String> {

    @Query("SELECT COUNT(c) FROM CloudKitchen c WHERE c.city = :city AND c.area = :area")
    long countByCityAndArea(String city, String area);
}
