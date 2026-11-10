package com.cryptolab.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cryptolab.persistence.entity.PortfolioHoldingEntity;

public interface PortfolioHoldingRepository extends JpaRepository<PortfolioHoldingEntity, Long> {

    List<PortfolioHoldingEntity> findByAssetSymbolIgnoreCase(String assetSymbol);
}