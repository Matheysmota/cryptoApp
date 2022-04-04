package com.matheus.mota.cryptoapp.utils

import android.widget.TextView
import com.matheus.mota.cryptoapp.cryptoHome.CryptoCoinsAdapter.CryptoCoin
import com.matheus.mota.cryptoapp.cryptoInfo.CryptoChipsAdapter.CryptoChips
import com.matheus.mota.cryptoapp.cryptoInfo.CryptoTeamsAdapter.CryptoTeams

val cryptoCoinsCollection: Collection<CryptoCoin> = (
        listOf(
            CryptoCoin("(BTC) Bitcoin", "#1", false),
            CryptoCoin("(ETH) Etherium", "#2", false),
            CryptoCoin("(SOL) Solana", "#3", false),
            CryptoCoin("(BND) Binance Coin", "#4", false),
            CryptoCoin("(XRP) XRP", "#5", false),
            CryptoCoin("(LUNA) Terra", "#6", false),
            CryptoCoin("(AVAX) Avalanche", "#7", false),
            CryptoCoin("cryptoCoin8", "#8", false),
            CryptoCoin("cryptoCoin9", "#9", false),
            CryptoCoin("cryptoCoin10", "#10", false),
            CryptoCoin("cryptoCoin11", "#11", false),
            CryptoCoin("cryptoCoin12", "#12", false),
            CryptoCoin("cryptoCoin13", "#13", false)
        )
        )

var cryptoChipsCollection: Collection<CryptoChips> = (
        listOf(
            CryptoChips("tag1", "tag2", "tag3", "tag4", "tag5")
        )
        )

var cryptoTeamsCollection: Collection<CryptoTeams> = (
        listOf(
            CryptoTeams("Satoshi Nakamoto", "Founder", null),
            CryptoTeams("Satoshi Nakamoto", "Founder", null),
            CryptoTeams("Satoshi Nakamoto", "Founder", null),
            CryptoTeams("Satoshi Nakamoto", "Founder", null),
            CryptoTeams("Satoshi Nakamoto", "Founder", null),
            CryptoTeams("Satoshi Nakamoto", "Founder", null)
        )
        )


fun verification(coin: CryptoCoin, description: TextView){
    for (cryptoCoin in cryptoCoinsCollection) {
        if (coin == cryptoCoin) {
            //comparete
            changeTheDescription(coin, description)
            //set my coin
            break
        }
    }
}

fun changeTheDescription(coin: CryptoCoin, description: TextView) {
    if (coin.cryptoName == "(BTC) Bitcoin") {
        description.text = descriptionBTC
    }
}



fun setTeam(coin: CryptoCoin): Collection<CryptoTeams> {
    var teams = cryptoTeamsCollection
    when (coin.cryptoName) {
        "(BTC) Bitcoin" -> {
            val teamBtc: List<CryptoTeams> = listOf(
                CryptoTeams("Satoshi Nakamoto", "Founder", null)
            )
            teams = teamBtc
        }
    }
    return teams
}

enum class myCoins {
    BTC,
    ETH,
}

val descriptionBTC = "descrição btc"


fun setChips(coin: CryptoCoin): Collection<CryptoChips> {
    var chips = cryptoChipsCollection
    when (coin.cryptoName) {
        "(BTC) Bitcoin" -> {
            val chipsBtc: List<CryptoChips> = listOf(
                CryptoChips(
                    "btc1", "btc2", "btc3", "btc4", "btc5"
                )
            )
            chips = chipsBtc
        }
    }
    return chips
}
