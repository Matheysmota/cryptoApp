package com.matheus.mota.cryptoapp.cryptoHome.CryptoCoinsAdapter

import com.matheus.mota.cryptoapp.cryptoInfo.CryptoChipsAdapter.CryptoChips
import com.matheus.mota.cryptoapp.cryptoInfo.CryptoTeamsAdapter.CryptoTeams
import java.io.Serializable


data class CryptoCoin(
    val cryptoName: String,
    val ranking: String,
    var favorite: Boolean
//    var cryptoTeam: List<CryptoTeams>
): Serializable {

}