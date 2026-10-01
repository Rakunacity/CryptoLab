package com.cryptolab.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Trade {
    private String symbol;
    private TradeType type;
    private BigDecimal amount;
    private BigDecimal price;
    private LocalDateTime timestamp;

    public Trade(
            String symbol,
            TradeType type,
            BigDecimal amount,
            BigDecimal price,
            LocalDateTime timestamp
    ) {
        this.symbol = symbol;
        this.type = type;
        this.amount = amount;
        this.price = price;
        this.timestamp = timestamp;
    }

    public String getSymbol() {
        return symbol;
    }

    public TradeType getType() {
        return type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "symbol='" + symbol + '\'' +
                ", type=" + type +
                ", amount=" + amount +
                ", price=" + price +
                ", timestamp=" + timestamp +
                '}';
    }
}