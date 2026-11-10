package com.cryptolab.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.cryptolab.dto.DashboardAssetResponse;
import com.cryptolab.model.CryptoAsset;
import com.cryptolab.model.Market;
import com.cryptolab.model.Portfolio;

class DashboardServiceTest {

    @Test
    void returnsSortedAssetsWithOwnedAmounts() {
        Market market = new Market();
        market.addAsset(new CryptoAsset("SOL", "Solana", new BigDecimal("150.00")));
        market.addAsset(new CryptoAsset("BTC", "Bitcoin", new BigDecimal("65000.25")));

        Portfolio portfolio = new Portfolio();
        portfolio.addCrypto("SOL", new BigDecimal("12.00"));

        DashboardService dashboardService = new DashboardService(market, portfolio);

        List<DashboardAssetResponse> assets = dashboardService.getAssets();

        assertEquals(2, assets.size());
        assertEquals("BTC", assets.get(0).asset());
        assertEquals(0, BigDecimal.ZERO.compareTo(assets.get(0).youOwn()));
        assertEquals("SOL", assets.get(1).asset());
        assertEquals(0, new BigDecimal("12.00").compareTo(assets.get(1).youOwn()));
    }
}