package com.cryptolab.model;

import java.math.BigDecimal;

public class CryptoAsset {

    private String symbol;
    private String name;
    private BigDecimal price;

    public CryptoAsset(String symbol, String name, BigDecimal price) {
        this.symbol = symbol;
        this.name = name;
        this.price = price;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }
    public BigDecimal getPrice() {
        return this.price;
    }

    public void changePrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return symbol + " - " + name + " - " + price;
    }
}
