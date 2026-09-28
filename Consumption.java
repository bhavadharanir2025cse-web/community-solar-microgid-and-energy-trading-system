package com.example.communitysolar.model;
import jakarta.persistence.*;
@Entity
@Table(name = "consumption")
public class Consumption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long consumptionId;
    private Long userId;

    private Double energyConsumed;

    private String date;

    public Consumption() {
    }

    public Consumption(Long userId, Double energyConsumed, String date) {
        this.userId = userId;
        this.energyConsumed = energyConsumed;
        this.date = date;
    }

    public Long getConsumptionId() {
        return consumptionId;
    }

    public void setConsumptionId(Long consumptionId) {
        this.consumptionId = consumptionId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Double getEnergyConsumed() {
        return energyConsumed;
    }

    public void setEnergyConsumed(Double energyConsumed) {
        this.energyConsumed = energyConsumed;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
