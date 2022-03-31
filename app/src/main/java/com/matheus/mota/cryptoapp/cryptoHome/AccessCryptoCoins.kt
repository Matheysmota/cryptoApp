package com.matheus.mota.cryptoapp.cryptoHome

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.matheus.mota.cryptoapp.R
import com.matheus.mota.cryptoapp.databinding.AccessCryptoCoinsBinding


class AccessCryptoCoins @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet?,
    defStyleAttrs: Int = 0
): ConstraintLayout(context, attrs, defStyleAttrs){
    private val binding = AccessCryptoCoinsBinding
        .inflate(LayoutInflater.from(context), this, true)
    //variable responsible for receiving and invoking states
//    private var state: CryptoCoinsState = CryptoCoinsState.IsNotFavorite
    var listener: AccessCryptoCoinClicklListener? = null

    init {
        binding.favoriteIconImageView.setOnClickListener{
            listener?.setClickListener()
        }
    }

    // Has the responsibility of programmatically set the State
    fun setIsFavorite(){
        binding.favoriteIconImageView.setBackgroundResource(R.drawable.is_favorite)
    }
    fun setIsNotFavorite() {
        binding.favoriteIconImageView.setBackgroundResource(R.drawable.is_not_favorite)
    }

    fun setCoinsName(cryptoName: String){
        binding.cryptoCoinTextView.text = cryptoName
    }
    fun setRankingCoin(cryptoRanking: String){
        binding.cryptoCountTextView.text = cryptoRanking
    }
//    sealed class CryptoCoinsState(val favorite: Boolean) {
//        object IsNotFavorite : CryptoCoinsState(true) // will be default -> favorite_border_24
//        object IsFavorite : CryptoCoinsState(false) // will be filled -> favorite_24
//    }

}

interface AccessCryptoCoinClicklListener{
    fun setClickListener()
}