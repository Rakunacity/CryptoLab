package com.cryptolab.model;

import java.util.ArrayList;
import java.util.List;

public final class TradeHistory {
    private static final List<Trade> history = new ArrayList<>();

    public static List<Trade> getTradesBySymbol(String symbol) {
        return history.stream().filter(trade -> trade.getSymbol().compareTo(symbol.toUpperCase()) == 0).toList();
    }

    public static List<Trade> getTradesByType(TradeType type) {
        return history.stream().filter(trade -> trade.getType().compareTo(type) == 0).toList();
    }

    public static void addTrade(Trade trade) {
        history.add(trade);
    }

    public static List<Trade> getAllTrades() {
        return List.copyOf(history);
    }

    public static String tradeHistoryToString() {
        return "TradeHistory{history=" + history + '}';
    }

}
