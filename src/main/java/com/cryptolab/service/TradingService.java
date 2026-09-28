package com.cryptolab.service;

import java.math.BigDecimal;

import com.cryptolab.model.CryptoAsset;
import com.cryptolab.model.Market;
import com.cryptolab.model.Portfolio;

public class TradingService {

    public static boolean buy(String symbol, BigDecimal amount, Market market, Portfolio porfolio) {

        CryptoAsset asset = market.getAsset(symbol);
        if (asset == null) {
            return false;
        }

        BigDecimal buyCost = asset.getPrice().multiply(amount);
        if (buyCost.compareTo( porfolio.getCashBalance()) >= 0 ) {
            return false;
        }

        porfolio.addCrypto(symbol, amount);
        porfolio.updateCashBalance(buyCost.negate());

        return true;
    }

}
