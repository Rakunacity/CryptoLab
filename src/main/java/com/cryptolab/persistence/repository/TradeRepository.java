package com.cryptolab.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cryptolab.model.TradeType;
import com.cryptolab.persistence.entity.TradeEntity;

public interface TradeRepository extends JpaRepository<TradeEntity, Long> {

    List<TradeEntity> findBySymbolIgnoreCase(String symbol);

    List<TradeEntity> findByType(TradeType type);
}