package com.matheus.mota.cryptoapp

import android.os.Bundle
import com.matheus.mota.cryptoapp.CryptoCoins.CryptoChipsAdapter.CryptoChips
import com.matheus.mota.cryptoapp.CryptoCoins.CryptoChipsAdapter.CryptoChipsAdapter
import com.matheus.mota.cryptoapp.CryptoCoins.CryptoTeamsAdapter.CryptoTeams
import com.matheus.mota.cryptoapp.CryptoCoins.CryptoTeamsAdapter.CryptoTeamsAdapter
import com.matheus.mota.cryptoapp.CryptoCoins.hidenData.CryptoCoinInfoList
import com.matheus.mota.cryptoapp.databinding.ActivityCryptoCoinInfoBinding

class CryptoCoinInfoActivity : CryptoCoinInfoList() {
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