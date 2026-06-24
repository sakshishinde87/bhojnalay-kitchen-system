package com.kitchen.bhojnalay.service;

import java.util.List;

import com.kitchen.bhojnalay.entity.User;

public interface ManagerService {

    User addManager(String cloudKitchenId, User manager);

    List<User> getAllManagers();

    User getManagerById(Long managerId);

    User updateManager(Long managerId, User manager);

    void deleteManager(Long managerId);
}