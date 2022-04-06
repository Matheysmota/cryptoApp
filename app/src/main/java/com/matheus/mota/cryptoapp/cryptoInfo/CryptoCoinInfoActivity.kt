package com.matheus.mota.cryptoapp.cryptoInfo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.matheus.mota.cryptoapp.R
import com.matheus.mota.cryptoapp.cryptoHome.CryptoHomeActivity
import com.matheus.mota.cryptoapp.cryptoHome.cryptoCoinsAdapter.CryptoCoin
import com.matheus.mota.cryptoapp.cryptoInfo.CryptoChipsAdapter.CryptoChips
import com.matheus.mota.cryptoapp.cryptoInfo.CryptoChipsAdapter.CryptoChipsAdapter
import com.matheus.mota.cryptoapp.cryptoInfo.CryptoTeamsAdapter.CryptoTeams
import com.matheus.mota.cryptoapp.cryptoInfo.CryptoTeamsAdapter.CryptoTeamsAdapter
import com.matheus.mota.cryptoapp.databinding.ActivityCryptoCoinInfoBinding


class CryptoCoinInfoActivity : AppCompatActivity() {
    lateinit var binding: ActivityCryptoCoinInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCryptoCoinInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.extras
        val coin = data?.getSerializable("coin")
        initMyCoinInfo(coin as CryptoCoin)
    }

    private fun initMyCoinInfo(coin: CryptoCoin){
        setCryptoChipsAdapter(coin)
        setCryptoTeamsAdapter(coin)
        binding.descriptionTextView.text = coin.description
        initOptionMenu(coin)
    }
    private fun initOptionMenu(coin: CryptoCoin) {
        with(binding.myCoinTollBar) {
            inflateMenu(R.menu.coin_info_menu)
            title = coin.cryptoName
            menu.findItem(R.id.action_return).setOnMenuItemClickListener {
                val intent = Intent(this@CryptoCoinInfoActivity, CryptoHomeActivity::class.java)
                startActivity(intent)
                true
            }
        }
    }
    private fun setCryptoChipsAdapter(coin: CryptoCoin){
        val recyclerCryptoChips = binding.chipsRecyclerView
        val chipsList: MutableList<CryptoChips> = mutableListOf()
        //create cryptoCoins
        chipsList.addAll(listOf(coin.chips))

        val cryptoAdapter = CryptoChipsAdapter(this, chipsList)
        recyclerCryptoChips.adapter = cryptoAdapter
    }
    private fun setCryptoTeamsAdapter(coin: CryptoCoin){
        val recyclerCryptoTeams = binding.teamsRecyclerView
        val teamsList: MutableList<CryptoTeams> = mutableListOf()

        //create cryptoCoins
        teamsList.addAll(coin.teams)

        val cryptoAdapter = CryptoTeamsAdapter(this, teamsList)
        recyclerCryptoTeams.adapter = cryptoAdapter
    }
}
