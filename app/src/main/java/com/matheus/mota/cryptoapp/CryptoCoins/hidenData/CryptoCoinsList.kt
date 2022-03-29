package com.matheus.mota.cryptoapp.CryptoCoins.hidenData

import androidx.appcompat.app.AppCompatActivity
import com.matheus.mota.cryptoapp.CryptoCoins.CryptoCoinsAdapter.CryptoCoin
import com.matheus.mota.cryptoapp.CryptoCoins.CryptoCoinsAdapter.CryptoCoinAdapter

abstract class CryptoCoinsList: AppCompatActivity() {



    //create cryptoCoins
    val cryptoCoinsCollection: Collection<CryptoCoin> = (
            listOf(
                CryptoCoin("(BTC) Bitcoin", "#1", false),
                CryptoCoin("(ETH) Etherium","#2", false),
                CryptoCoin("(SOL) Solana","#3", false),
                CryptoCoin("(BND) Binance Coin","#4", false),
                CryptoCoin("(XRP) XRP","#5", false),
                CryptoCoin("(LUNA) Terra","#6", false),
                CryptoCoin("(AVAX) Avalanche","#7", false),
                CryptoCoin("(AVAX) Avalanche","#7", false),
                CryptoCoin("(AVAX) Avalanche","#7", false),
                CryptoCoin("(AVAX) Avalanche","#7", false),
                CryptoCoin("(AVAX) Avalanche","#7", false),
                CryptoCoin("(AVAX) Avalanche","#7", false),
                CryptoCoin("(AVAX) Avalanche","#7", false)
            )
            )

}