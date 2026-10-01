package com.cryptolab.model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Market {
    private Map<String, CryptoAsset> market = new HashMap<>();

    public void addAsset(CryptoAsset asset) {
        this.market.put(asset.getSymbol().toUpperCase(), asset);
    }

    public CryptoAsset getAsset(String symbol) {
        return this.market.get(symbol.toUpperCase());
    }

    public void changeAssetPrice(String symbol, BigDecimal price) {

        if(price.compareTo(BigDecimal.ZERO) <= 0 ) return; 

        String symbolUpperCase = symbol.toUpperCase();
        CryptoAsset asset = this.getAsset(symbolUpperCase);

        if(asset == null) return;

        asset.changePrice(price);
    }

    public void printAll() {
        System.out.println(this.market.toString());
    }
}
