package com.cryptolab.model;

import org.junit.jupiter.api.Test;
import static com.cryptolab.TestUtils.marketWithAsset;
import static com.cryptolab.Utils.bd;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarketTest {
    @Test 
    void changePriceForKnownAsset() {
        Market market = marketWithAsset("ETH", "3501.18");
        market.changeAssetPrice("ETH", bd("3657.41"));

        assertEquals(0, bd("3657.41").compareTo(market.getAsset("ETH").getPrice()));
    }

}
