package com.cryptolab;

import com.cryptolab.model.CryptoAsset;
import com.cryptolab.model.Market;

import static com.cryptolab.Utils.bd;

public class Main {

    public static void main(String[] args) {

        CryptoAsset bitcoin = new CryptoAsset("BTC", "Bitcoin", bd("65000.25"));
        CryptoAsset ethereum = new CryptoAsset("ETH", "Ethereum", bd("3500"));
        CryptoAsset solana = new CryptoAsset("SOL", "Solana", bd("150"));

        Market market = new Market();
        market.addAsset(bitcoin);
        market.addAsset(ethereum);
        market.addAsset(solana);

        market.printAll();

    }
}