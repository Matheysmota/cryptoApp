package com.matheus.mota.cryptoapp.cryptoInfo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.matheus.mota.cryptoapp.cryptoHome.CryptoCoinsAdapter.CryptoCoin
import com.matheus.mota.cryptoapp.cryptoInfo.CryptoChipsAdapter.CryptoChips
import com.matheus.mota.cryptoapp.cryptoInfo.CryptoChipsAdapter.CryptoChipsAdapter
import com.matheus.mota.cryptoapp.cryptoInfo.CryptoTeamsAdapter.CryptoTeams
import com.matheus.mota.cryptoapp.cryptoInfo.CryptoTeamsAdapter.CryptoTeamsAdapter
import com.matheus.mota.cryptoapp.databinding.ActivityCryptoCoinInfoBinding
import com.matheus.mota.cryptoapp.utils.*


class CryptoCoinInfoActivity : AppCompatActivity() {
    lateinit var binding: ActivityCryptoCoinInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCryptoCoinInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val data = intent.extras
        val coin = data?.getSerializable("coin") as CryptoCoin
        initInterface(coin)
    }

    private fun initInterface(coin: CryptoCoin){
        setCryptoChipsAdapter(coin)
        setCryptoTeamsAdapter(coin)
        verification(coin, binding.descriptionTextView)
    }
    private fun setCryptoChipsAdapter(coin: CryptoCoin){
        val recyclerCryptoChips = binding.chipsRecyclerView
        val chipsList: MutableList<CryptoChips> = mutableListOf()
        //create cryptoCoins
        setChips(coin).let { chipsList.addAll(it) }

        val cryptoAdapter = CryptoChipsAdapter(this, chipsList)
        recyclerCryptoChips.adapter = cryptoAdapter
    }
    private fun setCryptoTeamsAdapter(coin: CryptoCoin){
        val recyclerCryptoTeams = binding.teamsRecyclerView
        val teamsList: MutableList<CryptoTeams> = mutableListOf()

        //create cryptoCoins
        setTeam(coin).let { teamsList.addAll(it) }

        val cryptoAdapter = CryptoTeamsAdapter(this, teamsList)
        recyclerCryptoTeams.adapter = cryptoAdapter
    }


}
