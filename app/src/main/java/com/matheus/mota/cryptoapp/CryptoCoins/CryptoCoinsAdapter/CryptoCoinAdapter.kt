package com.matheus.mota.cryptoapp.CryptoCoins.CryptoCoinsAdapter
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.matheus.mota.cryptoapp.CryptoCoins.AccessCryptoCoins
import com.matheus.mota.cryptoapp.R

class CryptoCoinAdapter(private val context: Context, private val cryptoCoins: MutableList<CryptoCoin>): RecyclerView.Adapter<CryptoCoinAdapter.CryptoCoinViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoCoinViewHolder {
        val cryptoView = LayoutInflater.from(context).inflate(R.layout.coins_list, parent, false)
        val holder = CryptoCoinViewHolder(cryptoView)
        return holder
    }
    override fun onBindViewHolder(holder: CryptoCoinViewHolder, position: Int) {
        val coins = cryptoCoins[position]
        holder.coinsList.setCoinsName(coins.cryptoName)
        holder.coinsList.setRankingCoin(coins.ranking)
        if (coins.favorite){
            holder.coinsList.setIsFavorite()
        } else {
            holder.coinsList.setIsNotFavorite()
        }
    }
    override fun getItemCount(): Int = cryptoCoins.size


    inner class CryptoCoinViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val coinsList = itemView.findViewById<AccessCryptoCoins>(R.id.listAccessCryptoCoin)
    }
}