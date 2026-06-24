package com.kitchen.bhojnalay.service;

import java.util.List;

import com.kitchen.bhojnalay.dto.CloudKitchenManagerResponseDto;
import com.kitchen.bhojnalay.entity.CloudKitchen;


public interface CloudKitchenService {

    CloudKitchen addCloudKitchen(CloudKitchen cloudKitchen);

    CloudKitchen getCloudKitchenById(String cloudKitchenId);

    List<CloudKitchen> getAllCloudKitchens();

    CloudKitchen updateCloudKitchen(String cloudKitchenId, CloudKitchen cloudKitchen);

    void deleteCloudKitchen(String cloudKitchenId);
    
    List<CloudKitchenManagerResponseDto> getKitchensWithManagers();

	//List<CloudKitchenManagerResponseDto> getKitchensWithManagers();
}