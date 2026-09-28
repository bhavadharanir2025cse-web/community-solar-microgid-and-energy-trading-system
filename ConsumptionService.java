package com.example.communitysolar.service;

import com.example.communitysolar.model.Consumption;
import com.example.communitysolar.repository.ConsumptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsumptionService {

    private final ConsumptionRepository consumptionRepository;

    public ConsumptionService(ConsumptionRepository consumptionRepository) {
        this.consumptionRepository = consumptionRepository;
    }

    public Consumption saveConsumption(Consumption consumption) {
        return consumptionRepository.save(consumption);
    }

    public List<Consumption> getAllConsumption() {
        return consumptionRepository.findAll();
    }

    public Optional<Consumption> getConsumptionById(Long id) {
        return consumptionRepository.findById(id);
    }

    public Consumption updateConsumption(Long id, Consumption consumption) {
        Consumption existingConsumption = consumptionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consumption record not found"));

        existingConsumption.setUserId(consumption.getUserId());
        existingConsumption.setEnergyConsumed(consumption.getEnergyConsumed());
        existingConsumption.setDate(consumption.getDate());

        return consumptionRepository.save(existingConsumption);
    }

    public void deleteConsumption(Long id) {
        consumptionRepository.deleteById(id);
    }
}
