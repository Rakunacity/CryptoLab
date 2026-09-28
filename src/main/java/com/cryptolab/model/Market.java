package com.cryptolab.model;
import java.util.HashMap;
import java.util.Map;

public class Market {
    private Map<String, CryptoAsset> market = new HashMap<>();

    public void addAsset(CryptoAsset asset) {
        this.market.put(asset.getSymbol().toUpperCase(), asset);
    }

    public CryptoAsset getAsset (String symbol) {
        return this.market.get(symbol.toUpperCase());
    }

    public void printAll () {
        System.out.println(this.market.toString());
    }
}
