package com.cryptolab.config;

import java.math.BigDecimal;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cryptolab.model.CryptoAsset;
import com.cryptolab.model.Market;
import com.cryptolab.model.Portfolio;

@Configuration
public class MarketConfiguration {

    @Bean
    public Market market() {
        Market market = new Market();
        market.addAsset(new CryptoAsset("BTC", "Bitcoin", new BigDecimal("62150.00")));
        market.addAsset(new CryptoAsset("ETH", "Ethereum", new BigDecimal("2425.00")));
        market.addAsset(new CryptoAsset("SOL", "Solana", new BigDecimal("145.00")));
        return market;
    }

    @Bean
    public Portfolio portfolio() {
        return new Portfolio();
    }
}