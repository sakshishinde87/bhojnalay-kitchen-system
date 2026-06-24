package com.kitchen.bhojnalay.service.impl;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kitchen.bhojnalay.entity.CloudKitchen;
import com.kitchen.bhojnalay.entity.Role;
import com.kitchen.bhojnalay.entity.User;
import com.kitchen.bhojnalay.repository.CloudKitchenRepository;
import com.kitchen.bhojnalay.repository.UserRepository;
import com.kitchen.bhojnalay.service.DeliveryBoyService;

@Service
public class DeliveryBoyServiceImpl implements DeliveryBoyService {

    private final UserRepository userRepository;
    private final CloudKitchenRepository cloudKitchenRepository;
    private final PasswordEncoder passwordEncoder;

    public DeliveryBoyServiceImpl(UserRepository userRepository,
                                  CloudKitchenRepository cloudKitchenRepository,
                                  PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.cloudKitchenRepository = cloudKitchenRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User addDeliveryBoy(String cloudKitchenId, User deliveryBoy) {

        CloudKitchen cloudKitchen = cloudKitchenRepository.findById(cloudKitchenId)
                .orElseThrow(() -> new RuntimeException("Cloud Kitchen not found"));

        if (userRepository.existsByEmail(deliveryBoy.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        if (userRepository.existsByPhoneNo(deliveryBoy.getPhoneNo())) {
            throw new RuntimeException("Phone number already exists");
        }

        deliveryBoy.setRole(Role.DELIVERY_BOY);
        deliveryBoy.setPassword(passwordEncoder.encode(deliveryBoy.getPassword()));
        deliveryBoy.setCloudKitchen(cloudKitchen);

        return userRepository.save(deliveryBoy);
    }

    @Override
    public List<User> getAllDeliveryBoys() {
        return userRepository.findByRole(Role.DELIVERY_BOY);
    }
}