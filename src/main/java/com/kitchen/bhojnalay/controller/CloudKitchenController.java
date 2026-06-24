package com.kitchen.bhojnalay.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.kitchen.bhojnalay.dto.CloudKitchenManagerResponseDto;
import com.kitchen.bhojnalay.entity.CloudKitchen;
import com.kitchen.bhojnalay.service.CloudKitchenService;

@RestController
@RequestMapping("/api/cloud-kitchens")
public class CloudKitchenController {

    private final CloudKitchenService cloudKitchenService;

    public CloudKitchenController(CloudKitchenService cloudKitchenService) {
        this.cloudKitchenService = cloudKitchenService;
    }

    @PostMapping
    public CloudKitchen addCloudKitchen(@RequestBody CloudKitchen cloudKitchen) {
        return cloudKitchenService.addCloudKitchen(cloudKitchen);
    }

    @GetMapping("/{cloudKitchenId}")
    public CloudKitchen getCloudKitchenById(@PathVariable String cloudKitchenId) {
        return cloudKitchenService.getCloudKitchenById(cloudKitchenId);
    }

    @GetMapping
    public List<CloudKitchen> getAllCloudKitchens() {
        return cloudKitchenService.getAllCloudKitchens();
    }

    @PutMapping("/{cloudKitchenId}")
    public CloudKitchen updateCloudKitchen(
            @PathVariable String cloudKitchenId,
            @RequestBody CloudKitchen cloudKitchen) {

        return cloudKitchenService.updateCloudKitchen(cloudKitchenId, cloudKitchen);
    }

    @DeleteMapping("/{cloudKitchenId}")
    public String deleteCloudKitchen(@PathVariable String cloudKitchenId) {
        cloudKitchenService.deleteCloudKitchen(cloudKitchenId);
        return "Cloud Kitchen deleted successfully";
    }
    
    @GetMapping("/with-managers")
    public List<CloudKitchenManagerResponseDto> getKitchensWithManagers() {
        return cloudKitchenService.getKitchensWithManagers();
    }
}