package com.kitchen.bhojnalay.service;

import java.util.List;

import com.kitchen.bhojnalay.entity.User;

public interface UserService {

    User createUser(User user);

    User getUserById(Long userId);

    List<User> getAllUsers();

    User updateUser(Long userId, User user);

    void deleteUser(Long userId);
}