package com.example.communitysolar.repository;

import com.example.communitysolar.model.Trade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TradeRepository extends JpaRepository<Trade, Long> {
}