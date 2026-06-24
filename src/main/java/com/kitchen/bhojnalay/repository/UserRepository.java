package com.kitchen.bhojnalay.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kitchen.bhojnalay.entity.Role;
import com.kitchen.bhojnalay.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);

    boolean existsByPhoneNo(String phoneNo);

    Optional<User> findByEmail(String email);
    
    List<User> findByRole(Role role);
    
    boolean existsByCloudKitchen_CloudKitchenId(String cloudKitchenId);

    Optional<User> findByCloudKitchen_CloudKitchenIdAndRole(String cloudKitchenId, Role role);
    
    List<User> findByCloudKitchen_CloudKitchenId(String cloudKitchenId);

	
}