package com.matheus.mota.cryptoapp.CryptoCoins

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.matheus.mota.cryptoapp.databinding.AccessCryptoCoinsBinding


class AccessCryptoCoins @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet?,
    defStyleAttrs: Int = 0
): ConstraintLayout(context, attrs, defStyleAttrs){
    private val binding = AccessCryptoCoinsBinding
        .inflate(LayoutInflater.from(context), this, true)
    //variable responsible for receiving and invoking states
    private var state: CryptoCoinsState = CryptoCoinsState.isNotFavorite

    init {
        refreshState()
    }

    private fun refreshState() {
        binding.favoriteIconImageView.isEnabled = state.favorite
        refreshDrawableState()
    }

    // Has the responsibility of programmatically set the State
    fun setIsFavorite(){
        state = CryptoCoinsState.isFavorite
        refreshState()
    }
    fun setIsNotFavorite() {
        state = CryptoCoinsState.isNotFavorite
        refreshState()
    }

    fun setCoinsName(cryptoName: String){
        binding.cryptoCoinTextView.text = cryptoName
    }
    fun setRankingCoin(cryptoRanking: String){
        binding.cryptoCountTextView.text = cryptoRanking
    }
    sealed class CryptoCoinsState(val favorite: Boolean){
        object isNotFavorite : CryptoCoinsState(true) // will be default -> favorite_border_24
        object isFavorite : CryptoCoinsState(false) // will be filled -> favorite_24
    }

}