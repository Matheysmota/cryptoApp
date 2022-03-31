package com.matheus.mota.cryptoapp.cryptoInfo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.matheus.mota.cryptoapp.cryptoInfo.CryptoChipsAdapter.CryptoChips
import com.matheus.mota.cryptoapp.cryptoInfo.CryptoChipsAdapter.CryptoChipsAdapter
import com.matheus.mota.cryptoapp.cryptoInfo.CryptoTeamsAdapter.CryptoTeams
import com.matheus.mota.cryptoapp.cryptoInfo.CryptoTeamsAdapter.CryptoTeamsAdapter
import com.matheus.mota.cryptoapp.databinding.ActivityCryptoCoinInfoBinding
import com.matheus.mota.cryptoapp.utils.cryptoChipsCollection
import com.matheus.mota.cryptoapp.utils.cryptoTeamsCollection

class CryptoCoinInfoActivity : AppCompatActivity() {
    lateinit var binding: ActivityCryptoCoinInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCryptoCoinInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
    }
    private fun initRecyclerView(){
        setCryptoChipsAdapter()
        setCryptoTeamsAdapter()
    }
    private fun setCryptoChipsAdapter(){
        val recyclerCryptoChips = binding.chipsRecyclerView
        val chipsList: MutableList<CryptoChips> = mutableListOf()

        //create cryptoCoins
        chipsList.addAll(cryptoChipsCollection)

        val cryptoAdapter = CryptoChipsAdapter(this, chipsList)
        recyclerCryptoChips.adapter = cryptoAdapter
    }
    private fun setCryptoTeamsAdapter(){
        val recyclerCryptoTeams = binding.teamsRecyclerView
        val teamsList: MutableList<CryptoTeams> = mutableListOf()

        //create cryptoCoins
        teamsList.addAll(cryptoTeamsCollection)

        val cryptoAdapter = CryptoTeamsAdapter(this, teamsList)
        recyclerCryptoTeams.adapter = cryptoAdapter
    }
}