package com.cryptolab.model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static com.cryptolab.Utils.bd;

public class Portfolio {

    private BigDecimal cash = bd("10000");

    private Map<String, BigDecimal> cryptoMap = new HashMap<>();

    public void addCrypto(String symbol, BigDecimal amount) {
        BigDecimal prevAmount = cryptoMap.getOrDefault(symbol.toUpperCase(), BigDecimal.ZERO);
        this.cryptoMap.put(symbol.toUpperCase(), amount.add(prevAmount));
    }

    public void deductCrypto(String symbol, BigDecimal amount) {
        this.addCrypto(symbol, amount.negate());
    }

    public BigDecimal getCryptoAmount(String symbol) {
        return cryptoMap.getOrDefault(symbol.toUpperCase(), BigDecimal.ZERO);
    }

    public BigDecimal getCashBalance() {
        return this.cash;
    }

    public void addCash(BigDecimal amount) {
        this.cash = this.cash.add(amount);
    }

    public void deductCash(BigDecimal amount) {
        this.cash = this.cash.subtract(amount);
    }

    public Map<String, BigDecimal> getAllCryptos() {
        return Map.copyOf(this.cryptoMap); 
    }

}
