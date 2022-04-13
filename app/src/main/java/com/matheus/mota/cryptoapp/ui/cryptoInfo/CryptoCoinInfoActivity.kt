package com.matheus.mota.cryptoapp.ui.cryptoInfo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.matheus.mota.cryptoapp.model.CryptoCoin
import com.matheus.mota.cryptoapp.model.coinInfo.CryptoCoinInfo
import com.matheus.mota.cryptoapp.webClient.service.CryptoInfoService
import com.matheus.mota.cryptoapp.databinding.ActivityCryptoCoinInfoBinding
import com.matheus.mota.cryptoapp.model.coinInfo.Tag
import com.matheus.mota.cryptoapp.model.coinInfo.Team
import com.matheus.mota.cryptoapp.ui.cryptoInfo.CryptoChipsAdapter.CryptoChipsAdapter
import com.matheus.mota.cryptoapp.ui.cryptoInfo.CryptoTeamsAdapter.CryptoTeamsAdapter
import com.matheus.mota.cryptoapp.webClient.CryptoInfoRetrofit
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

        val data = intent.extras
        coin = data?.getSerializable("coin") as CryptoCoin
        getCryptoInfo()

    }
    private fun setCryptoChipsAdapter(coin: CryptoCoinInfo){
        val recyclerCryptoChips = binding.chipsRecyclerView
        val chipsList: MutableList<Tag> = mutableListOf()
        //create cryptoCoins
        chipsList.addAll(coin.tags)

        val cryptoAdapter = CryptoChipsAdapter(this, chipsList)
        recyclerCryptoChips.adapter = cryptoAdapter
    }
    private fun setCryptoTeamsAdapter(coin: CryptoCoinInfo){
        val recyclerCryptoTeams = binding.teamsRecyclerView
        val teamsList: MutableList<Team> = mutableListOf()

        //create cryptoCoins
        teamsList.addAll(coin.team)

        val cryptoAdapter = CryptoTeamsAdapter(this, teamsList)
        recyclerCryptoTeams.adapter = cryptoAdapter
    }

    fun getCryptoInfo(){

        val retrofitService = CryptoInfoRetrofit.getCryptoInfoRetrofit("https://api.coinpaprika.com/")
        val cryptoInfoService = retrofitService.create(CryptoInfoService::class.java)

        cryptoInfoService.getCryptoCoinInfo(coin.id).enqueue(object : retrofit2.Callback<CryptoCoinInfo>{
            override fun onResponse(
                call: Call<CryptoCoinInfo>,
                response: Response<CryptoCoinInfo>
            ) {
                if (response.isSuccessful){
                    myCryptoCoinInfo = response.body()!!
                    binding.run {
                        descriptionTextView.text = myCryptoCoinInfo.description
                        setCryptoChipsAdapter(myCryptoCoinInfo)
                        setCryptoTeamsAdapter(myCryptoCoinInfo)
                    }
                }
            }
            override fun onFailure(call: Call<CryptoCoinInfo>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
//        Thread(Runnable {
//            callback.invoke(
//
//            )
//
//        })
    }

}
//private fun initMyCoinInfo(coin: CryptoCoin){
//    setCryptoChipsAdapter(coin)
//    setCryptoTeamsAdapter(coin)
//    binding.descriptionTextView.text = coin.description
//    initOptionMenu(coin)
//}
//private fun initOptionMenu(coin: CryptoCoin) {
//    with(binding.myCoinTollBar) {
//        inflateMenu(com.matheus.mota.cryptoapp.R.menu.coin_info_menu)
//        title = coin.name
//        menu.findItem(com.matheus.mota.cryptoapp.R.id.action_return).setOnMenuItemClickListener {
//            finish()
//            true
//        }
//    }
//
//}
