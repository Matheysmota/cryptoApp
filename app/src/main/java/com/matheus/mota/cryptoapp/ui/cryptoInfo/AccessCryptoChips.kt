package com.matheus.mota.cryptoapp.ui.cryptoInfo

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
    fun setMyChip(firstCryptoChip: String){
        binding.myChip.text = firstCryptoChip
    }
}

