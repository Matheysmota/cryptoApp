package com.matheus.mota.cryptoapp.ui.cryptoHome

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.matheus.mota.cryptoapp.R
import com.matheus.mota.cryptoapp.model.CryptoCoin
import com.matheus.mota.cryptoapp.webClient.service.CryptoHomeService
import com.matheus.mota.cryptoapp.databinding.ActivityCryptoHomeBinding
import com.matheus.mota.cryptoapp.webClient.CryptoHomeRetrofit
import retrofit2.Call
import retrofit2.Response


class CryptoHomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityCryptoHomeBinding
    private lateinit var dialog: AlertDialog
    private var myCryptoList = mutableListOf<CryptoCoin>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCryptoHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //implementations
        configureApiIntegrate()
        initOptionMenu()
        setFavoriteFilter()
        setAllFilter()


    }

    private fun initRecyclerView(list: MutableList<CryptoCoin>) {
        //create cryptoCoins
        val cryptoList: MutableList<CryptoCoin> = mutableListOf()

        cryptoList.addAll(list)
        setUpRecyclerView(binding, cryptoList)

    }


    private fun initOptionMenu() {
        binding.exitMenu.setOnClickListener {
            alertDialog()
        }
    }

    private fun myCryptoCoinsList(): List<CryptoCoin> {
        return if (myCryptoList.any { it.favorite }) {
            myCryptoList.filter { it.favorite }
        } else {
            myCryptoList
        }
    }

    private fun setFavoriteFilter() {
        binding.onlyFavoriteButton.setOnClickListener {
            myCryptoCoinsList().let { initRecyclerView(it as MutableList<CryptoCoin>) }
            Toast.makeText(this, "Suas cryptoMoedas favoritas", Toast.LENGTH_SHORT).show()
        }
    }
    private fun configureApiIntegrate(){
        val retrofitClient = CryptoHomeRetrofit.getCryptoRetrofit("https://api.coinpaprika.com/")
        val cryptoService = retrofitClient.create(CryptoHomeService::class.java)

        cryptoService.getCryptoCoin().enqueue(object : retrofit2.Callback<List<CryptoCoin>> {
            override fun onResponse(call: Call<List<CryptoCoin>>, response: Response<List<CryptoCoin>>) {
                if (response.isSuccessful){
                    response.body()?.iterator()?.forEach {
                        myCryptoList.addAll(listOf(it))
                    }
                    Thread.sleep(1000)
                    initRecyclerView(myCryptoList)
                } else {
                    Toast.makeText(this@CryptoHomeActivity, "Deu ruim", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<List<CryptoCoin>>, t: Throwable) {
                Toast.makeText(this@CryptoHomeActivity, "Deu ruim mesmo", Toast.LENGTH_SHORT).show()
            }
        })

    }
    private fun setAllFilter() {
        binding.allButton.setOnClickListener {
            initRecyclerView(myCryptoList)
        }
    }
    private fun alertDialog() {
        val build = AlertDialog.Builder(this, R.style.ThemeMyDialog)
        val view = layoutInflater.inflate(R.layout.alert_dialog, null)
        build.setView(view)

        val cancelButton = view.findViewById<Button>(R.id.cancelButton)
        cancelButton.setOnClickListener{ dialog.dismiss() }

        val exitButton = view.findViewById<Button>(R.id.exitButton)
        exitButton.setOnClickListener {
            Toast.makeText(this, "Até logo!", Toast.LENGTH_SHORT).show()
            finish()
        }

        dialog = build.create()
        dialog.show()
    }



}



