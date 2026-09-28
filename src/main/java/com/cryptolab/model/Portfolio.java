package com.cryptolab.model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Portfolio {

    private BigDecimal cash = new BigDecimal("10000");
    private String cashCode = "USD";
    private String cashSymbol = "$";

    private Map<String, BigDecimal> cryptoMap = new HashMap();

    public void addCrypto(String symbol, BigDecimal amount) {
        BigDecimal prevAmount = cryptoMap.getOrDefault(symbol.toUpperCase(), BigDecimal.ZERO);
        this.cryptoMap.put(symbol.toUpperCase(), amount.add(prevAmount));
    }

    public BigDecimal getCryptoAmount (String symbol) {
        return cryptoMap.get(symbol.toUpperCase());
    }

    public BigDecimal getCashBalance () {
        return this.cash;
    }



}
