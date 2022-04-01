package com.matheus.mota.cryptoapp.utils

import com.matheus.mota.cryptoapp.cryptoHome.CryptoCoinsAdapter.CryptoCoin
import com.matheus.mota.cryptoapp.cryptoInfo.CryptoChipsAdapter.CryptoChips
import com.matheus.mota.cryptoapp.cryptoInfo.CryptoTeamsAdapter.CryptoTeams

val cryptoCoinsCollection: Collection<CryptoCoin> = (
        listOf(
            CryptoCoin("(BTC) Bitcoin", "#1", false),
            CryptoCoin("(ETH) Etherium","#2", false),
            CryptoCoin("(SOL) Solana","#3", false),
            CryptoCoin("(BND) Binance Coin","#4", false),
            CryptoCoin("(XRP) XRP","#5", false),
            CryptoCoin("(LUNA) Terra","#6", false),
            CryptoCoin("(AVAX) Avalanche","#7", false),
            CryptoCoin("cryptoCoin8","#8", false),
            CryptoCoin("cryptoCoin9","#9", false),
            CryptoCoin("cryptoCoin10","#10", false),
            CryptoCoin("cryptoCoin11","#11", false),
            CryptoCoin("cryptoCoin12","#12", false),
            CryptoCoin("cryptoCoin13","#13", false)
        )
        )

val cryptoChipsCollection: Collection<CryptoChips> = (
        listOf(
            CryptoChips("tag1", "tag2", "tag3", "tag4", "tag5")
        )
        )

val cryptoTeamsCollection: Collection<CryptoTeams> = (
        listOf(
            CryptoTeams("Satoshi Nakamoto", "Founder", null),
            CryptoTeams("Satoshi Nakamoto", "Founder", null),
            CryptoTeams("Satoshi Nakamoto", "Founder", null),
            CryptoTeams("Satoshi Nakamoto", "Founder", null),
            CryptoTeams("Satoshi Nakamoto", "Founder", null),
            CryptoTeams("Satoshi Nakamoto", "Founder", null)
        )
        )

enum class myCoin{
    BTC,
    ETH,
    SOL,
    BND,
    XRP,
    LUNA,
    AVAX,
    CRYPTO_8,
    CRYPTO_9,
    CRYPTO_10,
    CRYPTO_11,
    CRYPTO_12,
    CRYPTO_13
}



