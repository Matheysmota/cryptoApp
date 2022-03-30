package com.matheus.mota.cryptoapp

import android.os.Bundle
import com.matheus.mota.cryptoapp.CryptoCoins.CryptoChips
import com.matheus.mota.cryptoapp.CryptoCoins.CryptoChipsAdapter
import com.matheus.mota.cryptoapp.CryptoCoins.hidenData.CryptoChipsList
import com.matheus.mota.cryptoapp.databinding.ActivityCryptoCoinInfoBinding

class CryptoCoinInfoActivity : CryptoChipsList() {
    lateinit var binding: ActivityCryptoCoinInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCryptoCoinInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
    }
    private fun initRecyclerView(){

        val recyclerCryptoCoins = binding.chipsRecyclerView
        val chipsList: MutableList<CryptoChips> = mutableListOf()

        //create cryptoCoins
        chipsList.addAll(cryptoChipsCollection)

        val cryptoAdapter = CryptoChipsAdapter(this, chipsList)
        recyclerCryptoCoins.adapter = cryptoAdapter
    }
}