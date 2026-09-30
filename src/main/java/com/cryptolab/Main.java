package com.cryptolab;

import java.math.BigDecimal;

import com.cryptolab.model.CryptoAsset;
import com.cryptolab.model.Market;

public class Main {

    public static void main(String[] args) {

        CryptoAsset bitcoin = new CryptoAsset("BTC", "Bitcoin", new BigDecimal("65000.25"));
        CryptoAsset ethereum = new CryptoAsset("ETH", "Ethereum", new BigDecimal("3500.00"));
        CryptoAsset solana = new CryptoAsset("SOL", "Solana", new BigDecimal("150.00"));

        Market market = new Market();
        market.addAsset(bitcoin);
        market.addAsset(ethereum);
        market.addAsset(solana);

        market.printAll();

    }
}