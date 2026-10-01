package com.cryptolab;

import com.cryptolab.model.CryptoAsset;
import com.cryptolab.model.Market;

import static com.cryptolab.Utils.bd;

public class TestUtils {
    public static Market marketWithAsset(String symbol, String price) {
        Market market = new Market();
        market.addAsset(new CryptoAsset(symbol, symbol + " asset", bd(price)));
        return market;
    }
}
