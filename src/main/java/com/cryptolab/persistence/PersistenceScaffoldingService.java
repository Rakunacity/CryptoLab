package com.cryptolab.persistence;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cryptolab.persistence.repository.PortfolioHoldingRepository;
import com.cryptolab.persistence.repository.PortfolioRepository;
import com.cryptolab.persistence.repository.TradeRepository;

@Service
public class PersistenceScaffoldingService {

    private final PortfolioRepository portfolioRepository;
    private final PortfolioHoldingRepository portfolioHoldingRepository;
    private final TradeRepository tradeRepository;

    public PersistenceScaffoldingService(
            PortfolioRepository portfolioRepository,
            PortfolioHoldingRepository portfolioHoldingRepository,
            TradeRepository tradeRepository) {
        this.portfolioRepository = portfolioRepository;
        this.portfolioHoldingRepository = portfolioHoldingRepository;
        this.tradeRepository = tradeRepository;
    }

    public List<String> describePreparedRepositories() {
        return List.of(
                portfolioRepository.getClass().getSimpleName(),
                portfolioHoldingRepository.getClass().getSimpleName(),
                tradeRepository.getClass().getSimpleName());
    }
}