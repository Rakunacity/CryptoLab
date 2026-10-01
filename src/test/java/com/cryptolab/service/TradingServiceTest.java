package com.cryptolab.service;

import com.cryptolab.model.Market;
import com.cryptolab.model.Portfolio;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static com.cryptolab.TestUtils.marketWithAsset;

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
    void rejectsBuyOfUnknownAssetWithoutChangingPortfolio() {
        Portfolio portfolio = new Portfolio();

        boolean purchased = TradingService.buy("DOGE", BigDecimal.ONE, marketWithAsset("BTC", "100"), portfolio);

        assertFalse(purchased);
        assertEquals(0, new BigDecimal("10000").compareTo(portfolio.getCashBalance()));
        assertEquals(0, BigDecimal.ZERO.compareTo(portfolio.getCryptoAmount("DOGE")));
    }

    @Test
    void rejectsBuyThatExceedsAvailableCash() {
        Portfolio portfolio = new Portfolio();

        boolean purchased = TradingService.buy("BTC", new BigDecimal("2"), marketWithAsset("BTC", "6000"), portfolio);

        assertFalse(purchased);
        assertEquals(0, new BigDecimal("10000").compareTo(portfolio.getCashBalance()));
        assertEquals(0, BigDecimal.ZERO.compareTo(portfolio.getCryptoAmount("BTC")));
    }

    @Test
    void allowsBuyThatUsesEntireCashBalance() {
        Portfolio portfolio = new Portfolio();

        boolean purchased = TradingService.buy("BTC", BigDecimal.ONE, marketWithAsset("BTC", "10000"), portfolio);

        assertTrue(purchased);
        assertEquals(0, BigDecimal.ZERO.compareTo(portfolio.getCashBalance()));
        assertEquals(0, BigDecimal.ONE.compareTo(portfolio.getCryptoAmount("BTC")));
    }

    @Test
    void rejectsBuyOfZeroOrNegativeAmountWithoutChangingPortfolio() {
        Market market = marketWithAsset("BTC", "100");
        Portfolio portfolio = new Portfolio();

        assertFalse(TradingService.buy("BTC", BigDecimal.ZERO, market, portfolio));
        assertFalse(TradingService.buy("BTC", new BigDecimal("-1"), market, portfolio));

        assertEquals(0, new BigDecimal("10000").compareTo(portfolio.getCashBalance()));
        assertEquals(0, BigDecimal.ZERO.compareTo(portfolio.getCryptoAmount("BTC")));
    }

    @Test
    void sellsKnownCryptoAssetAndUpdatesPortfolio() {
        Market market = marketWithAsset("BTC", "5000.00");
        Portfolio portfolio = new Portfolio();

        TradingService.buy("BTC", new BigDecimal("1.5"), market, portfolio);
        boolean sold = TradingService.sell("BTC", new BigDecimal("1"), market, portfolio);

        assertTrue(sold);
        assertEquals(0, new BigDecimal("7500.00").compareTo(portfolio.getCashBalance()));
        assertEquals(0, new BigDecimal("0.5").compareTo(portfolio.getCryptoAmount("BTC")));
    }

    @Test
    void rejectsSellOfUnknownAssetWithoutChangingPortfolio() {
        Portfolio portfolio = new Portfolio();

        boolean sold = TradingService.sell("DOGE", BigDecimal.ONE, marketWithAsset("BTC", "100"), portfolio);

        assertFalse(sold);
        assertEquals(0, new BigDecimal("10000").compareTo(portfolio.getCashBalance()));
        assertEquals(0, BigDecimal.ZERO.compareTo(portfolio.getCryptoAmount("DOGE")));
    }

    @Test
    void rejectsSellThatExceedsAvailableCryptoAmount() {
        Portfolio portfolio = new Portfolio();

        Market market = marketWithAsset("BTC", "5000");

        TradingService.buy("BTC", new BigDecimal("2"), market, portfolio);
        boolean sold = TradingService.sell("BTC", new BigDecimal("3"), market, portfolio);
        assertFalse(sold);

        assertEquals(0, new BigDecimal("0").compareTo(portfolio.getCashBalance()));
        assertEquals(0, new BigDecimal("2").compareTo(portfolio.getCryptoAmount("BTC")));
    }

    @Test
    void allowsSellThatUsesEntireCryptoBalance() {
        Market market = marketWithAsset("BTC", "5000");
        Portfolio portfolio = new Portfolio();
        TradingService.buy("BTC", new BigDecimal("2"), market, portfolio);

        boolean sold = TradingService.sell("BTC", new BigDecimal("2"), market, portfolio);

        assertTrue(sold);
        assertEquals(0, new BigDecimal("10000").compareTo(portfolio.getCashBalance()));
        assertEquals(0, BigDecimal.ZERO.compareTo(portfolio.getCryptoAmount("BTC")));
    }

    @Test
    void rejectsSellOfZeroOrNegativeAmountWithoutChangingPortfolio() {
        Market market = marketWithAsset("BTC", "5000");
        Portfolio portfolio = new Portfolio();
        TradingService.buy("BTC", BigDecimal.ONE, market, portfolio);

        assertFalse(TradingService.sell("BTC", BigDecimal.ZERO, market, portfolio));
        assertFalse(TradingService.sell("BTC", new BigDecimal("-1"), market, portfolio));

        assertEquals(0, new BigDecimal("5000").compareTo(portfolio.getCashBalance()));
        assertEquals(0, BigDecimal.ONE.compareTo(portfolio.getCryptoAmount("BTC")));
    }

}