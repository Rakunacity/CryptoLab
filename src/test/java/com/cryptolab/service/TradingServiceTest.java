package com.cryptolab.service;

import com.cryptolab.model.CryptoAsset;
import com.cryptolab.model.Market;
import com.cryptolab.model.Portfolio;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TradingServiceTest {

    @Test
    void buysKnownAssetAndUpdatesPortfolio() {
        Market market = marketWithAsset("BTC", "2500.00");
        Portfolio portfolio = new Portfolio();

        boolean purchased = TradingService.buy("btc", new BigDecimal("2"), market, portfolio);

        assertTrue(purchased);
        assertEquals(0, new BigDecimal("5000.00").compareTo(portfolio.getCashBalance()));
        assertEquals(0, new BigDecimal("2").compareTo(portfolio.getCryptoAmount("BTC")));
    }

    @Test
    void rejectsUnknownAssetWithoutChangingPortfolio() {
        Portfolio portfolio = new Portfolio();

        boolean purchased = TradingService.buy("DOGE", BigDecimal.ONE, marketWithAsset("BTC", "100"), portfolio);

        assertFalse(purchased);
        assertEquals(0, new BigDecimal("10000").compareTo(portfolio.getCashBalance()));
        assertEquals(0, BigDecimal.ZERO.compareTo(portfolio.getCryptoAmount("DOGE")));
    }

    @Test
    void rejectsPurchaseThatExceedsAvailableCash() {
        Portfolio portfolio = new Portfolio();

        boolean purchased = TradingService.buy("BTC", new BigDecimal("2"), marketWithAsset("BTC", "6000"), portfolio);

        assertFalse(purchased);
        assertEquals(0, new BigDecimal("10000").compareTo(portfolio.getCashBalance()));
        assertEquals(0, BigDecimal.ZERO.compareTo(portfolio.getCryptoAmount("BTC")));
    }

    @Test
    void allowsPurchaseThatUsesEntireCashBalance() {
        Portfolio portfolio = new Portfolio();

        boolean purchased = TradingService.buy("BTC", BigDecimal.ONE, marketWithAsset("BTC", "10000"), portfolio);

        assertTrue(purchased);
        assertEquals(0, BigDecimal.ZERO.compareTo(portfolio.getCashBalance()));
        assertEquals(0, BigDecimal.ONE.compareTo(portfolio.getCryptoAmount("BTC")));
    }

    @Test
    void rejectsZeroOrNegativeAmountWithoutChangingPortfolio() {
        Market market = marketWithAsset("BTC", "100");
        Portfolio portfolio = new Portfolio();

        assertFalse(TradingService.buy("BTC", BigDecimal.ZERO, market, portfolio));
        assertFalse(TradingService.buy("BTC", new BigDecimal("-1"), market, portfolio));

        assertEquals(0, new BigDecimal("10000").compareTo(portfolio.getCashBalance()));
        assertEquals(0, BigDecimal.ZERO.compareTo(portfolio.getCryptoAmount("BTC")));
    }

    private Market marketWithAsset(String symbol, String price) {
        Market market = new Market();
        market.addAsset(new CryptoAsset(symbol, symbol + " asset", new BigDecimal(price)));
        return market;
    }
}