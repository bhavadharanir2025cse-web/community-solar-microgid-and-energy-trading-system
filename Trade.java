package com.example.communitysolar.model;

import jakarta.persistence.*;

@Entity
@Table(name = "trades")
public class Trade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tradeId;

    private Long sellerId;

    private Long buyerId;

    private Double energyAmount;

    private Double price;

    private String date;

    public Trade() {
    }

    public Trade(Long sellerId, Long buyerId, Double energyAmount, Double price, String date) {
        this.sellerId = sellerId;
        this.buyerId = buyerId;
        this.energyAmount = energyAmount;
        this.price = price;
        this.date = date;
    }

    public Long getTradeId() {
        return tradeId;
    }

    public void setTradeId(Long tradeId) {
        this.tradeId = tradeId;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public Double getEnergyAmount() {
        return energyAmount;
    }

    public void setEnergyAmount(Double energyAmount) {
        this.energyAmount = energyAmount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
