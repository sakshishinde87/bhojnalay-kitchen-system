package com.kitchen.bhojnalay.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.kitchen.bhojnalay.entity.User;
import com.kitchen.bhojnalay.service.DeliveryBoyService;

@RestController
@RequestMapping("/api/delivery-boys")
public class DeliveryBoyController {

    private final DeliveryBoyService deliveryBoyService;

    public DeliveryBoyController(DeliveryBoyService deliveryBoyService) {
        this.deliveryBoyService = deliveryBoyService;
    }

    @PostMapping("/cloud-kitchen/{cloudKitchenId}")
    public User addDeliveryBoy(@PathVariable String cloudKitchenId,
                               @RequestBody User deliveryBoy) {
        return deliveryBoyService.addDeliveryBoy(cloudKitchenId, deliveryBoy);
    }

    @GetMapping
    public List<User> getAllDeliveryBoys() {
        return deliveryBoyService.getAllDeliveryBoys();
    }
}