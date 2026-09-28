package com.cryptolab.model;
import java.util.HashMap;

public class Market {
    private HashMap<String, CryptoAsset> market = new HashMap<>();

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
