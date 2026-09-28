package com.example.communitysolar.controller;

import com.example.communitysolar.service.EnergyService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/energy")
public class EnergyController {

    private final EnergyService energyService;

    public EnergyController(EnergyService energyService) {
        this.energyService = energyService;
    }

    @GetMapping("/surplus/{userId}")
    public Double getSurplus(@PathVariable Long userId) {
        return energyService.calculateSurplus(userId);
    }
}
