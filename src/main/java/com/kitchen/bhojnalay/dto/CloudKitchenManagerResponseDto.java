package com.kitchen.bhojnalay.dto;

import com.kitchen.bhojnalay.entity.CloudKitchen;
import com.kitchen.bhojnalay.entity.User;

public class CloudKitchenManagerResponseDto {

    private CloudKitchen cloudKitchen;
    private User manager;

    public CloudKitchenManagerResponseDto() {
    }

    public CloudKitchenManagerResponseDto(CloudKitchen cloudKitchen, User manager) {
        this.cloudKitchen = cloudKitchen;
        this.manager = manager;
    }

    public CloudKitchen getCloudKitchen() {
        return cloudKitchen;
    }

    public void setCloudKitchen(CloudKitchen cloudKitchen) {
        this.cloudKitchen = cloudKitchen;
    }

    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }
}