package com.cryptolab.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.cryptolab.service.TradingService;
import static com.cryptolab.TestUtils.marketWithAsset;
import static com.cryptolab.Utils.bd;
import com.cryptolab.service.PortfolioService;

public class PortfolioServiceTest {

    @Test
    void getsTotalPortfolioValue() {

        Market market = marketWithAsset("BTC", "4000"); // ?? why not includes name?
        CryptoAsset asset = new CryptoAsset("ETH", "Etherium", bd("1000"));
        market.addAsset(asset);

        Portfolio portfolio = new Portfolio();

        TradingService.buy("btc", bd("1"), market, portfolio);
        TradingService.buy("ETh", bd("1"), market, portfolio);

        assertEquals(0, bd("10000").compareTo(PortfolioService.getTotalPortfolioValue(portfolio, market)));

        market.changeAssetPrice("eTH", bd("1500"));
        market.changeAssetPrice("bTc", bd("5000"));

        assertEquals(0, bd("11500").compareTo(PortfolioService.getTotalPortfolioValue(portfolio, market)));

    }
}
