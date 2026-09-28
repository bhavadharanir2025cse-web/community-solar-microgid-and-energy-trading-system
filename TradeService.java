package com.example.communitysolar.service;

import com.example.communitysolar.model.Trade;
import com.example.communitysolar.repository.TradeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TradeService {

    private final TradeRepository tradeRepository;
    private final EnergyService energyService;

    public TradeService(TradeRepository tradeRepository,
                        EnergyService energyService) {
        this.tradeRepository = tradeRepository;
        this.energyService = energyService;
    }

    public Trade saveTrade(Trade trade) {

        Double surplus =
                energyService.calculateSurplus(trade.getSellerId());

        if (trade.getEnergyAmount() > surplus) {

            throw new RuntimeException(
                    "Insufficient surplus energy. Available: "
                            + surplus + " kWh"
            );
        }

        return tradeRepository.save(trade);
    }

    public List<Trade> getAllTrades() {
        return tradeRepository.findAll();
    }

    public Optional<Trade> getTradeById(Long id) {
        return tradeRepository.findById(id);
    }

    public Trade updateTrade(Long id, Trade trade) {

        Trade existingTrade = tradeRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Trade not found"));

        existingTrade.setSellerId(trade.getSellerId());
        existingTrade.setBuyerId(trade.getBuyerId());
        existingTrade.setEnergyAmount(trade.getEnergyAmount());
        existingTrade.setPrice(trade.getPrice());
        existingTrade.setDate(trade.getDate());

        return tradeRepository.save(existingTrade);
    }

    public void deleteTrade(Long id) {
        tradeRepository.deleteById(id);
    }
}