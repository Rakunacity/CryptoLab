package com.cryptolab.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cryptolab.persistence.entity.PortfolioEntity;

public interface PortfolioRepository extends JpaRepository<PortfolioEntity, Long> {

    Optional<PortfolioEntity> findByOwnerName(String ownerName);
}