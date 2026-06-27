package com.kitchen.bhojnalay.dto;

import java.util.List;

import com.kitchen.bhojnalay.entity.CloudKitchen;
import com.kitchen.bhojnalay.entity.User;

public class CloudKitchenStaffResponseDto {

    private CloudKitchen cloudKitchen;
    private User manager;
    private List<User> deliveryBoys;

    public CloudKitchenStaffResponseDto() {
    }

    public CloudKitchenStaffResponseDto(CloudKitchen cloudKitchen, User manager, List<User> deliveryBoys) {
        this.cloudKitchen = cloudKitchen;
        this.manager = manager;
        this.deliveryBoys = deliveryBoys;
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

    public List<User> getDeliveryBoys() {
        return deliveryBoys;
    }

    public void setDeliveryBoys(List<User> deliveryBoys) {
        this.deliveryBoys = deliveryBoys;
    }
}