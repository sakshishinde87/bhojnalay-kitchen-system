package com.kitchen.bhojnalay.service.impl;

import java.util.List;
import java.util.Optional;

import com.kitchen.bhojnalay.dto.CloudKitchenDeliveryBoyResponseDto;
import com.kitchen.bhojnalay.dto.CloudKitchenManagerResponseDto;
import com.kitchen.bhojnalay.dto.CloudKitchenStaffResponseDto;

import org.springframework.stereotype.Service;


import com.kitchen.bhojnalay.entity.CloudKitchen;
import com.kitchen.bhojnalay.entity.Role;
import com.kitchen.bhojnalay.entity.User;
import com.kitchen.bhojnalay.repository.CloudKitchenRepository;
import com.kitchen.bhojnalay.repository.UserRepository;
import com.kitchen.bhojnalay.service.CloudKitchenService;

@Service
public class CloudKitchenServiceImpl implements CloudKitchenService {

    private final CloudKitchenRepository cloudKitchenRepository;
    private final UserRepository userRepository;

    public CloudKitchenServiceImpl(CloudKitchenRepository cloudKitchenRepository,
            UserRepository userRepository) {
this.cloudKitchenRepository = cloudKitchenRepository;
this.userRepository = userRepository;
}
    @Override
    public CloudKitchen addCloudKitchen(CloudKitchen cloudKitchen) {

        String cityCode = cloudKitchen.getCity()
                .substring(0, 3)
                .toUpperCase();

        String areaCode = cloudKitchen.getArea()
                .substring(0, 3)
                .toUpperCase();

        long count = cloudKitchenRepository.countByCityAndArea(
                cloudKitchen.getCity(),
                cloudKitchen.getArea()
        );

        String sequence = String.format("%03d", count + 1);

        String generatedId = cityCode + areaCode + sequence;

        cloudKitchen.setCloudKitchenId(generatedId);

        return cloudKitchenRepository.save(cloudKitchen);
    }

    @Override
    public CloudKitchen getCloudKitchenById(String cloudKitchenId) {

        return cloudKitchenRepository.findById(cloudKitchenId)
                .orElseThrow(() ->
                        new RuntimeException("Cloud Kitchen Not Found"));
    }

    @Override
    public List<CloudKitchen> getAllCloudKitchens() {

        return cloudKitchenRepository.findAll();
    }

    @Override
    public CloudKitchen updateCloudKitchen(
            String cloudKitchenId,
            CloudKitchen cloudKitchen) {

        CloudKitchen existing = getCloudKitchenById(cloudKitchenId);

        existing.setKitchenName(cloudKitchen.getKitchenName());
        existing.setOwnerName(cloudKitchen.getOwnerName());
        existing.setPhoneNo(cloudKitchen.getPhoneNo());
        existing.setEmail(cloudKitchen.getEmail());
        existing.setAddress(cloudKitchen.getAddress());
        existing.setArea(cloudKitchen.getArea());
        existing.setCity(cloudKitchen.getCity());
        existing.setDivision(cloudKitchen.getDivision());
        existing.setState(cloudKitchen.getState());
        existing.setCountry(cloudKitchen.getCountry());
        existing.setPincode(cloudKitchen.getPincode());
        existing.setGstNumber(cloudKitchen.getGstNumber());
        existing.setFoodLicenseNumber(cloudKitchen.getFoodLicenseNumber());
        existing.setActive(cloudKitchen.isActive());

        return cloudKitchenRepository.save(existing);
    }

    @Override
    public void deleteCloudKitchen(String cloudKitchenId) {

        CloudKitchen existing = getCloudKitchenById(cloudKitchenId);

        List<User> assignedUsers =
                userRepository.findByCloudKitchen_CloudKitchenId(cloudKitchenId);

        for (User user : assignedUsers) {
            userRepository.delete(user);
        }

        cloudKitchenRepository.delete(existing);
    }
    @Override
    public List<CloudKitchenManagerResponseDto> getKitchensWithManagers() {

        List<CloudKitchen> kitchens = cloudKitchenRepository.findAll();

        return kitchens.stream()
                .map(kitchen -> {

                    User manager = userRepository
                            .findByCloudKitchen_CloudKitchenIdAndRole(
                                    kitchen.getCloudKitchenId(),
                                    Role.MANAGER)
                            .orElse(null);

                    return new CloudKitchenManagerResponseDto(
                            kitchen,
                            manager
                    );
                })
                .toList();
    }
    
    @Override
    public List<CloudKitchenDeliveryBoyResponseDto> getKitchensWithDeliveryBoys() {

        List<CloudKitchen> kitchens = cloudKitchenRepository.findAll();

        return kitchens.stream()
                .map(kitchen -> {

                    List<User> deliveryBoys =
                            userRepository.findAllByCloudKitchen_CloudKitchenIdAndRole(
                                    kitchen.getCloudKitchenId(),
                                    Role.DELIVERY_BOY
                            );

                    return new CloudKitchenDeliveryBoyResponseDto(
                            kitchen,
                            deliveryBoys
                    );

                })
                .toList();
    }
    
    @Override
    public List<CloudKitchenStaffResponseDto> getKitchensWithStaff() {

        List<CloudKitchen> kitchens = cloudKitchenRepository.findAll();

        return kitchens.stream()
                .map(kitchen -> {

                    User manager = userRepository
                            .findByCloudKitchen_CloudKitchenIdAndRole(
                                    kitchen.getCloudKitchenId(),
                                    Role.MANAGER)
                            .orElse(null);

                    List<User> deliveryBoys = userRepository
                            .findAllByCloudKitchen_CloudKitchenIdAndRole(
                                    kitchen.getCloudKitchenId(),
                                    Role.DELIVERY_BOY);

                    return new CloudKitchenStaffResponseDto(
                            kitchen,
                            manager,
                            deliveryBoys
                    );

                })
                .toList();
    }
}