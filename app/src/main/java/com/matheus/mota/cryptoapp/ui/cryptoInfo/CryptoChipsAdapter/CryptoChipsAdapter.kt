package com.matheus.mota.cryptoapp.ui.cryptoInfo.CryptoChipsAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.matheus.mota.cryptoapp.ui.cryptoInfo.AccessCryptoChips
import com.matheus.mota.cryptoapp.R
import com.matheus.mota.cryptoapp.model.coinInfo.Tag

class CryptoChipsAdapter(private val context: Context, private val cryptoChips: MutableList<Tag>): RecyclerView.Adapter<CryptoChipsAdapter.CryptoChipsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoChipsViewHolder {
        val cryptoView = LayoutInflater.from(context).inflate(R.layout.chips_list, parent, false)
        val holder = CryptoChipsViewHolder(cryptoView)
        return holder
    }
    override fun onBindViewHolder(holder: CryptoChipsViewHolder, position: Int) {
        val chips = cryptoChips[position]
        holder.chipsList.setMyChip(chips.name)
         }
    override fun getItemCount(): Int = cryptoChips.size

    inner class CryptoChipsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val chipsList = itemView.findViewById<AccessCryptoChips>(R.id.listAccessCryptoChips)
    }
}