package com.matheus.mota.cryptoapp.ui.cryptoInfo

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.matheus.mota.cryptoapp.databinding.AccessCryptoTeamsBinding

class AccessCryptoTeams @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet?,
    defStyleAttrs: Int = 0
): ConstraintLayout(context, attrs, defStyleAttrs){
    private val binding = AccessCryptoTeamsBinding
        .inflate(LayoutInflater.from(context), this, true)

    // Has the responsibility of programmatically set the State
    fun setTittle(tittle: String){
        binding.tittleTextView.text = tittle
    }
    fun setSubTittle(subTittle: String) {
        binding.subTittleTextView.text = subTittle
    }
    fun setLine(line: Drawable){
        binding.line1.background = line
    }
}