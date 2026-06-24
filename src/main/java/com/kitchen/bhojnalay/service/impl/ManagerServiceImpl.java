package com.kitchen.bhojnalay.service.impl;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kitchen.bhojnalay.entity.CloudKitchen;
import com.kitchen.bhojnalay.entity.Role;
import com.kitchen.bhojnalay.entity.User;
import com.kitchen.bhojnalay.repository.CloudKitchenRepository;
import com.kitchen.bhojnalay.repository.UserRepository;
import com.kitchen.bhojnalay.service.ManagerService;

@Service
public class ManagerServiceImpl implements ManagerService {

    private final UserRepository userRepository;
    private final CloudKitchenRepository cloudKitchenRepository;
    private final PasswordEncoder passwordEncoder;

    public ManagerServiceImpl(UserRepository userRepository,
                              CloudKitchenRepository cloudKitchenRepository,
                              PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.cloudKitchenRepository = cloudKitchenRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User addManager(String cloudKitchenId, User manager) {

        CloudKitchen cloudKitchen = cloudKitchenRepository.findById(cloudKitchenId)
                .orElseThrow(() -> new RuntimeException("Cloud Kitchen not found"));

        if (userRepository.existsByEmail(manager.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        if (userRepository.existsByPhoneNo(manager.getPhoneNo())) {
            throw new RuntimeException("Phone number already exists");
        }

        manager.setRole(Role.MANAGER);
        manager.setPassword(passwordEncoder.encode(manager.getPassword()));
        manager.setCloudKitchen(cloudKitchen);

        return userRepository.save(manager);
    }

    @Override
    public List<User> getAllManagers() {
        return userRepository.findByRole(Role.MANAGER);
    }

    @Override
    public User getManagerById(Long managerId) {
        User manager = userRepository.findById(managerId)
                .orElseThrow(() -> new RuntimeException("Manager not found"));

        if (manager.getRole() != Role.MANAGER) {
            throw new RuntimeException("This user is not a manager");
        }

        return manager;
    }

    @Override
    public User updateManager(Long managerId, User manager) {

        User existingManager = getManagerById(managerId);

        existingManager.setUserName(manager.getUserName());
        existingManager.setPhoneNo(manager.getPhoneNo());
        existingManager.setEmail(manager.getEmail());
        existingManager.setAddress(manager.getAddress());

        if (manager.getPassword() != null && !manager.getPassword().isBlank()) {
            existingManager.setPassword(passwordEncoder.encode(manager.getPassword()));
        }

        return userRepository.save(existingManager);
    }

    @Override
    public void deleteManager(Long managerId) {
        User manager = getManagerById(managerId);
        userRepository.delete(manager);
    }
}