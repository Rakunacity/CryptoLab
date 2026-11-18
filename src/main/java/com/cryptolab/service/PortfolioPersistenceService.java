package com.cryptolab.service;

import java.math.BigDecimal;
import java.util.Optional;

import com.cryptolab.persistence.entity.PortfolioEntity;
import com.cryptolab.persistence.repository.PortfolioRepository;
import static com.cryptolab.Utils.bd;

public class PortfolioPersistenceService {

    private final BigDecimal startingCash = bd("10000");

    private final PortfolioRepository portfolioRepository;

    private PortfolioPersistenceService(PortfolioRepository portfolioRepository) {
        this.portfolioRepository = portfolioRepository;
    }

    public PortfolioEntity getOrCreatePortfolio(String ownerName) {
        Optional<PortfolioEntity> repository = this.portfolioRepository.findByOwnerName(ownerName);
        if (repository.isEmpty()) {
            portfolioRepository.save(startingCash);
        }

        return repository.orElse(null);
    }
}
