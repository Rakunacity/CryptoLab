package com.cryptolab.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cryptolab.dto.DashboardAssetResponse;
import com.cryptolab.model.CryptoAsset;
import com.cryptolab.model.Market;
import com.cryptolab.model.Portfolio;

@Service
public class DashboardService {

    private final Market market;
    private final Portfolio portfolio;

    public DashboardService(Market market, Portfolio portfolio) {
        this.market = market;
        this.portfolio = portfolio;
    }

    public List<DashboardAssetResponse> getAssets() {
        return market.getAllAssets().stream()
                .sorted(Comparator.comparing(CryptoAsset::getSymbol))
                .map(asset -> new DashboardAssetResponse(
                        asset.getSymbol(),
                        asset.getPrice(),
                        portfolio.getCryptoAmount(asset.getSymbol())))
                .toList();
    }
}