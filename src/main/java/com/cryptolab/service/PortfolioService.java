package com.cryptolab.service;

import java.math.BigDecimal;
import java.util.Map;

import com.cryptolab.model.Portfolio;
import com.cryptolab.model.Market;

public class PortfolioService {

    public static BigDecimal getTotalPortfolioValue(Portfolio portfolio, Market market) {

        Map<String, BigDecimal> cryptosMap = portfolio.getAllCryptos();
        BigDecimal total = new BigDecimal("0");

        for (Map.Entry<String, BigDecimal> entry : cryptosMap.entrySet()) {
            String key = entry.getKey();
            BigDecimal cryptoValue = market.getAsset(key).getPrice().multiply(portfolio.getCryptoAmount(key));
            total.add(cryptoValue);
        }

        return total.add(portfolio.getCashBalance());
    }
}
