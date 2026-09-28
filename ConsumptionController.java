package com.example.communitysolar.controller;

import com.example.communitysolar.model.Consumption;
import com.example.communitysolar.service.ConsumptionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consumption")
public class ConsumptionController {

    private final ConsumptionService consumptionService;

    public ConsumptionController(ConsumptionService consumptionService) {
        this.consumptionService = consumptionService;
    }

    @PostMapping
    public Consumption createConsumption(@RequestBody Consumption consumption) {
        return consumptionService.saveConsumption(consumption);
    }

    @GetMapping
    public List<Consumption> getAllConsumption() {
        return consumptionService.getAllConsumption();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Consumption> getConsumptionById(@PathVariable Long id) {
        return consumptionService.getConsumptionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public Consumption updateConsumption(
            @PathVariable Long id,
            @RequestBody Consumption consumption) {
        return consumptionService.updateConsumption(id, consumption);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteConsumption(@PathVariable Long id) {
        consumptionService.deleteConsumption(id);
        return ResponseEntity.ok("Consumption record deleted successfully");
    }
}
