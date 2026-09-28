package com.example.communitysolar.model;

import jakarta.persistence.*;

@Entity
@Table(name = "generation")
public class Generation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long generationId;

    private Long userId;

    private Double energyGenerated;

    private String date;

    public Generation() {
    }

    public Generation(Long userId, Double energyGenerated, String date) {
        this.userId = userId;
        this.energyGenerated = energyGenerated;
        this.date = date;
    }

    public Long getGenerationId() {
        return generationId;
    }

    public void setGenerationId(Long generationId) {
        this.generationId = generationId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Double getEnergyGenerated() {
        return energyGenerated;
    }

    public void setEnergyGenerated(Double energyGenerated) {
        this.energyGenerated = energyGenerated;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
