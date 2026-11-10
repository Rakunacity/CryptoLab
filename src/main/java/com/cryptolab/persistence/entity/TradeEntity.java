package com.cryptolab.persistence.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.cryptolab.model.TradeType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "trades")
public class TradeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String symbol;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private TradeType type;

    @Column(nullable = false, precision = 19, scale = 8)
    private BigDecimal amount;

    @Column(nullable = false, precision = 19, scale = 8)
    private BigDecimal executedPrice;

    @Column(nullable = false)
    private LocalDateTime executedAt;

    protected TradeEntity() {
    }

    public TradeEntity(String symbol, TradeType type, BigDecimal amount, BigDecimal executedPrice, LocalDateTime executedAt) {
        this.symbol = symbol;
        this.type = type;
        this.amount = amount;
        this.executedPrice = executedPrice;
        this.executedAt = executedAt;
    }

    public Long getId() {
        return id;
    }

    public String getSymbol() {
        return symbol;
    }

    public TradeType getType() {
        return type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public BigDecimal getExecutedPrice() {
        return executedPrice;
    }

    public LocalDateTime getExecutedAt() {
        return executedAt;
    }
}