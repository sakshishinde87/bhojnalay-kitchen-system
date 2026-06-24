package com.kitchen.bhojnalay.service;

import java.util.List;

import com.kitchen.bhojnalay.entity.User;

public interface DeliveryBoyService {

    User addDeliveryBoy(String cloudKitchenId, User deliveryBoy);

    List<User> getAllDeliveryBoys();

	
}