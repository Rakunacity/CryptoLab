package com.cryptolab.persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.cryptolab.persistence.repository.PortfolioHoldingRepository;
import com.cryptolab.persistence.repository.PortfolioRepository;
import com.cryptolab.persistence.repository.TradeRepository;

import static org.mockito.Mockito.mock;

class PersistenceScaffoldingServiceTest {

    @Test
    void exposesAllPreparedRepositoryTypes() {
        PersistenceScaffoldingService service = new PersistenceScaffoldingService(
                mock(PortfolioRepository.class),
                mock(PortfolioHoldingRepository.class),
                mock(TradeRepository.class));

        List<String> repositoryTypes = service.describePreparedRepositories();

        assertEquals(3, repositoryTypes.size());
    }
}