package com.cryptolab.persistence.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "portfolios")
public class PortfolioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String ownerName;

    @Column(nullable = false, precision = 19, scale = 8)
    private BigDecimal cashBalance;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<PortfolioHoldingEntity> holdings = new ArrayList<>();

    protected PortfolioEntity() {
    }

    public PortfolioEntity(String ownerName, BigDecimal cashBalance) {
        this.ownerName = ownerName;
        this.cashBalance = cashBalance;
    }

    public Long getId() {
        return id;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public BigDecimal getCashBalance() {
        return cashBalance;
    }

    public List<PortfolioHoldingEntity> getHoldings() {
        return holdings;
    }
}