package com.matheus.mota.cryptoapp.CryptoCoins

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.matheus.mota.cryptoapp.databinding.AccessCryptoChipsBinding

class AccessCryptoChips @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet?,
    defStyleAttrs: Int = 0
): ConstraintLayout(context, attrs, defStyleAttrs){
    private val binding = AccessCryptoChipsBinding
        .inflate(LayoutInflater.from(context), this, true)

    // Has the responsibility of programmatically set the State
    fun setFirstCryptoChip(firstCryptoChip: String){
        binding.firstChip.text = firstCryptoChip
    }
    fun setSecondCryptoChip(secondCryptoChip: String) {
        binding.secondChip.text = secondCryptoChip
    }
    fun setThirdCryptoChip(thirdCryptoChip: String) {
        binding.thirdChip.text = thirdCryptoChip
    }
    fun setFourthCryptoChip(fourthCryptoChip: String) {
        binding.fourthChip.text = fourthCryptoChip
    }
    fun setFifthCryptoChip(fifthCryptoChip: String) {
        binding.fifthChip.text = fifthCryptoChip
    }
}

