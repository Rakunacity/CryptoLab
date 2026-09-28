package com.cryptolab;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.cryptolab.model.CryptoAsset;
import com.cryptolab.model.Market;
import com.cryptolab.model.Portfolio;
import com.cryptolab.service.TradingService;

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

        CryptoAsset match = market.getAsset("BTC");
        System.out.println("AAaaaAA");
        System.out.println(match);
        System.out.println("AAaaaAA");

        bitcoin.changePrice(new BigDecimal("67500.00"));

        System.out.println("-----------------------------");
        market.printAll();
        System.out.println("-----------------------------");
        Portfolio portfolio = new Portfolio();
        TradingService.buy("BTC", new BigDecimal("0.01"), market, portfolio);

        System.out.println(portfolio.getCashBalance());
        System.out.println(portfolio.getCryptoAmount("BTC"));

    }
}