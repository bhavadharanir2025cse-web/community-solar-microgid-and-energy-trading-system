package com.example.communitysolar.service;

import com.example.communitysolar.model.Consumption;
import com.example.communitysolar.model.Generation;
import com.example.communitysolar.model.Trade;
import com.example.communitysolar.repository.ConsumptionRepository;
import com.example.communitysolar.repository.GenerationRepository;
import com.example.communitysolar.repository.TradeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnergyService {

    private final GenerationRepository generationRepository;
    private final ConsumptionRepository consumptionRepository;
    private final TradeRepository tradeRepository;

    public EnergyService(GenerationRepository generationRepository,
                         ConsumptionRepository consumptionRepository,
                         TradeRepository tradeRepository) {

        this.generationRepository = generationRepository;
        this.consumptionRepository = consumptionRepository;
        this.tradeRepository = tradeRepository;
    }

    public Double calculateSurplus(Long userId) {

        List<Generation> generations = generationRepository.findAll();
        List<Consumption> consumptions = consumptionRepository.findAll();
        List<Trade> trades = tradeRepository.findAll();

        double totalGeneration = 0;
        double totalConsumption = 0;
        double totalTraded = 0;

        // Calculate total generated energy
        for (Generation generation : generations) {

            if (generation.getUserId().equals(userId)) {
                totalGeneration += generation.getEnergyGenerated();
            }
        }

        // Calculate total consumed energy
        for (Consumption consumption : consumptions) {

            if (consumption.getUserId().equals(userId)) {
                totalConsumption += consumption.getEnergyConsumed();
            }
        }

        // Calculate energy already sold
        for (Trade trade : trades) {

            if (trade.getSellerId().equals(userId)) {
                totalTraded += trade.getEnergyAmount();
            }
        }

        // Available surplus
        return totalGeneration - totalConsumption - totalTraded;
    }
}