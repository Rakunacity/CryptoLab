package com.cryptolab;

import java.math.BigDecimal;

import com.cryptolab.model.CryptoAsset;
import com.cryptolab.model.Market;

public class TestUtils {
        public static Market marketWithAsset(String symbol, String price) {
        Market market = new Market();
        market.addAsset(new CryptoAsset(symbol, symbol + " asset", new BigDecimal(price)));
        return market;
    }
}
