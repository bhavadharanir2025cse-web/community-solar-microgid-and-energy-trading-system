package com.example.communitysolar.repository;

import com.example.communitysolar.model.Consumption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsumptionRepository extends JpaRepository<Consumption, Long> {
}