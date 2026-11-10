package com.cryptolab.persistence.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "portfolio_holdings")
public class PortfolioHoldingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "portfolio_id", nullable = false)
    private PortfolioEntity portfolio;

    @Column(nullable = false, length = 20)
    private String assetSymbol;

    @Column(nullable = false, precision = 19, scale = 8)
    private BigDecimal amount;

    protected PortfolioHoldingEntity() {
    }

    public PortfolioHoldingEntity(PortfolioEntity portfolio, String assetSymbol, BigDecimal amount) {
        this.portfolio = portfolio;
        this.assetSymbol = assetSymbol;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public PortfolioEntity getPortfolio() {
        return portfolio;
    }

    public String getAssetSymbol() {
        return assetSymbol;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}