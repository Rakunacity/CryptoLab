package com.cryptolab.dto;

import java.math.BigDecimal;

public record DashboardAssetResponse(
        String asset,
        BigDecimal price,
        BigDecimal youOwn) {
}