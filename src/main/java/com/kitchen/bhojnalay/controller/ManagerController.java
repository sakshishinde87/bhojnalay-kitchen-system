package com.kitchen.bhojnalay.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.kitchen.bhojnalay.entity.User;
import com.kitchen.bhojnalay.service.ManagerService;

@RestController
@RequestMapping("/api/managers")
public class ManagerController {

    private final ManagerService managerService;

    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @PostMapping("/cloud-kitchen/{cloudKitchenId}")
    public User addManager(@PathVariable String cloudKitchenId,
                           @RequestBody User manager) {
        return managerService.addManager(cloudKitchenId, manager);
    }

    @GetMapping
    public List<User> getAllManagers() {
        return managerService.getAllManagers();
    }

    @GetMapping("/{managerId}")
    public User getManagerById(@PathVariable Long managerId) {
        return managerService.getManagerById(managerId);
    }

    @PutMapping("/{managerId}")
    public User updateManager(@PathVariable Long managerId,
                              @RequestBody User manager) {
        return managerService.updateManager(managerId, manager);
    }

    @DeleteMapping("/{managerId}")
    public String deleteManager(@PathVariable Long managerId) {
        managerService.deleteManager(managerId);
        return "Manager deleted successfully";
    }
}