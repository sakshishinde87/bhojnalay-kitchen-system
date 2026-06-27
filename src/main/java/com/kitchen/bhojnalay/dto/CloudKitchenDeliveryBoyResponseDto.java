package com.kitchen.bhojnalay.dto;

import java.util.List;

import com.kitchen.bhojnalay.entity.CloudKitchen;
import com.kitchen.bhojnalay.entity.User;

public class CloudKitchenDeliveryBoyResponseDto {

    private CloudKitchen cloudKitchen;
    private List<User> deliveryBoys;

    public CloudKitchenDeliveryBoyResponseDto() {
    }

    public CloudKitchenDeliveryBoyResponseDto(CloudKitchen cloudKitchen, List<User> deliveryBoys) {
        this.cloudKitchen = cloudKitchen;
        this.deliveryBoys = deliveryBoys;
    }

    public CloudKitchen getCloudKitchen() {
        return cloudKitchen;
    }

    public void setCloudKitchen(CloudKitchen cloudKitchen) {
        this.cloudKitchen = cloudKitchen;
    }

    public List<User> getDeliveryBoys() {
        return deliveryBoys;
    }

    public void setDeliveryBoys(List<User> deliveryBoys) {
        this.deliveryBoys = deliveryBoys;
    }
}