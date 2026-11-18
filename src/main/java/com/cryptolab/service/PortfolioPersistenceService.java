package com.cryptolab.service;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cryptolab.persistence.entity.PortfolioEntity;
import com.cryptolab.persistence.repository.PortfolioRepository;
import static com.cryptolab.Utils.bd;

@Service 
public class PortfolioPersistenceService {

    private final PortfolioRepository portfolioRepository;

    public PortfolioPersistenceService(PortfolioRepository portfolioRepository) {
        this.portfolioRepository = portfolioRepository;
    }

    public PortfolioEntity getOrCreatePortfolio(String ownerName) {
        Optional<PortfolioEntity> repository = this.portfolioRepository.findByOwnerName(ownerName);
        if (repository.isEmpty()) {
            BigDecimal startingCash = bd("10000");
            return  portfolioRepository.save(new PortfolioEntity(ownerName, startingCash));
        } else {
            return repository.get();
        }

    
    }
}
