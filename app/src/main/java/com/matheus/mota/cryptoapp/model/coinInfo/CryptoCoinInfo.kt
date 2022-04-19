package com.matheus.mota.cryptoapp.model.coinInfo

import com.matheus.mota.cryptoapp.ui.cryptoInfo.CryptoChipsAdapter.CryptoChips
import com.matheus.mota.cryptoapp.ui.cryptoInfo.CryptoTeamsAdapter.CryptoTeams
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

data class CryptoCoinInfo(
val description: String,
val development_status: String,
val first_data_at: String,
val hardware_wallet: Boolean,
val hash_algorithm: String,
val id: String,
val is_active: Boolean,
val is_new: Boolean,
val last_data_at: String,
val links: Links,
val links_extended: List<LinksExtended>,
val message: String,
val name: String,
val open_source: Boolean,
val org_structure: String,
val proof_type: String,
val rank: Int,
val started_at: String,
val symbol: String,
val tags: List<Tag>?,
val team: List<Team>?,
val type: String,
val whitepaper: Whitepaper
)
