package com.cryptolab;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.cryptolab.model.CryptoAsset;

public class Main {

    public static void main(String[] args) {

        ArrayList<CryptoAsset> assetList = new ArrayList<>();

        CryptoAsset bitcoin = new CryptoAsset("BTC", "Bitcoin", new BigDecimal("65000.25"));
        CryptoAsset ethereum = new CryptoAsset("ETH", "Ethereum", new BigDecimal("3500.00"));
        CryptoAsset solana = new CryptoAsset("SOL", "Solana", new BigDecimal("150.00"));

        assetList.add(bitcoin);
        assetList.add(ethereum);
        assetList.add(solana);

        for (CryptoAsset asset : assetList) {
            System.out.println(asset);
        }

        CryptoAsset match = assetList.stream().filter(item -> "ETH".equals(item.getSymbol())).findFirst().orElse(null);
        System.out.println("AAaaaAA");
        System.out.println(match);
        System.out.println("AAaaaAA");

        bitcoin.changePrice(new BigDecimal("67500.00"));

        System.out.println("-----------------------------");

        for (CryptoAsset asset : assetList) {
            System.out.println(asset);
        }

    }
}