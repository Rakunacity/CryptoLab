package com.cryptolab.model;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import static com.cryptolab.TestUtils.marketWithAsset;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CryptoAssetTest {
    @Test 
    void changePriceForKnownAsset() {
        Market market = marketWithAsset("ETH", "3501.18");
        market.changeAssetPrice("ETH", new BigDecimal("3657.41"));

        assertEquals(0, new BigDecimal("3657.41").compareTo(market.getAsset("ETH").getPrice()));
    }

}
