package com.cryptolab.service;

import java.math.BigDecimal;

import com.cryptolab.model.CryptoAsset;
import com.cryptolab.model.Market;
import com.cryptolab.model.Portfolio;

public class TradingService {

    public static boolean buy(String symbol, BigDecimal amount, Market market, Portfolio portfolio) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            return false;
        }

        CryptoAsset asset = market.getAsset(symbol);
        if (asset == null) {
            return false;
        }

        BigDecimal buyCost = asset.getPrice().multiply(amount);
        if (buyCost.compareTo(portfolio.getCashBalance()) > 0) {
            return false;
        }

        portfolio.addCrypto(symbol, amount);
        portfolio.updateCashBalance(buyCost.negate());

        return true;
    }

    public static boolean sell(String symbol, BigDecimal amount, Market market, Portfolio portfolio) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            return false;
        }

        CryptoAsset asset = market.getAsset(symbol);
        if (asset == null) {
            return false;
        }

        if (amount.compareTo(portfolio.getCryptoAmount(symbol)) > 0) {
            return false;
        }

        BigDecimal sellResult = asset.getPrice().multiply(amount);
        portfolio.updateCashBalance(portfolio.getCashBalance().add(sellResult));
        portfolio.deductCrypto(symbol, amount);

        return true;
    }

}
