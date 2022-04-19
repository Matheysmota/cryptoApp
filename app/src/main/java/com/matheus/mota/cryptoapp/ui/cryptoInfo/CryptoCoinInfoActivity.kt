package com.matheus.mota.cryptoapp.ui.cryptoInfo

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.matheus.mota.cryptoapp.model.CryptoCoin
import com.matheus.mota.cryptoapp.model.coinInfo.CryptoCoinInfo
import com.matheus.mota.cryptoapp.webClient.service.CryptoInfoService
import com.matheus.mota.cryptoapp.databinding.ActivityCryptoCoinInfoBinding
import com.matheus.mota.cryptoapp.model.coinInfo.Tag
import com.matheus.mota.cryptoapp.model.coinInfo.Team
import com.matheus.mota.cryptoapp.ui.cryptoInfo.CryptoChipsAdapter.CryptoChipsAdapter
import com.matheus.mota.cryptoapp.ui.cryptoInfo.CryptoTeamsAdapter.CryptoTeamsAdapter
import com.matheus.mota.cryptoapp.webClient.CryptoInfoRetrofit
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response


class CryptoCoinInfoActivity : AppCompatActivity() {
    lateinit var binding: ActivityCryptoCoinInfoBinding
    private lateinit var coin: CryptoCoin
    private lateinit var myCryptoCoinInfo: CryptoCoinInfo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCryptoCoinInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.myCoinTollBar)

        val data = intent.extras
        coin = data?.getSerializable("coin") as CryptoCoin
        getCryptoInfo()

    }
    private fun setCryptoChipsAdapter(coin: CryptoCoinInfo){
        val recyclerCryptoChips = binding.chipsRecyclerView
        val chipsList: MutableList<Tag> = mutableListOf()
        //create cryptoCoins
        if (coin.tags == null) {
            chipsList.addAll(listOf(Tag(0,0, "","Null")))
        } else{
            chipsList.addAll(coin.tags)
        }

        val cryptoAdapter = CryptoChipsAdapter(this, chipsList)
        recyclerCryptoChips.adapter = cryptoAdapter
    }
    private fun setCryptoTeamsAdapter(coin: CryptoCoinInfo){
        val recyclerCryptoTeams = binding.teamsRecyclerView
        val teamsList: MutableList<Team> = mutableListOf()

        //create cryptoCoins
        if (coin.team == null) {
            teamsList.addAll(listOf(Team("", "Null", "No founder", null)))
        } else{
            teamsList.addAll(coin.team)
        }


        val cryptoAdapter = CryptoTeamsAdapter(this, teamsList)
        recyclerCryptoTeams.adapter = cryptoAdapter
    }
    private fun getCryptoInfo(){
        lifecycleScope.launch {
            val retrofitService = CryptoInfoRetrofit.getCryptoInfoRetrofit("https://api.coinpaprika.com/")
            val cryptoInfoService = retrofitService.create(CryptoInfoService::class.java)
            val myCoin = cryptoInfoService.getCryptoCoinInfo(coin.id).body()

            setCryptoInfo(myCoin)
        }
    }
    private fun setCryptoInfo(myCoin: CryptoCoinInfo?) {
        if(myCoin != null){
            setCryptoChipsAdapter(myCoin)
            setCryptoTeamsAdapter(myCoin)
            binding.descriptionTextView.text = myCoin.description
            binding.myCoinTollBar.title = "("+myCoin.symbol+") "+myCoin.name

        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
