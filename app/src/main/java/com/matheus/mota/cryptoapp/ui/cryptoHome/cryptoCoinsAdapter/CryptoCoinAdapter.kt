package com.matheus.mota.cryptoapp.ui.cryptoHome.cryptoCoinsAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.matheus.mota.cryptoapp.ui.cryptoHome.AccessCryptoCoins
import com.matheus.mota.cryptoapp.R
import com.matheus.mota.cryptoapp.model.CryptoCoin
import com.matheus.mota.cryptoapp.ui.cryptoHome.AccessCryptoCoinClicklListener


open class CryptoCoinAdapter(private val context: Context, private val cryptoCoins: MutableList<CryptoCoin>): RecyclerView.Adapter<CryptoCoinAdapter.CryptoCoinViewHolder>() {

    var notifyMyActivity: CryptoCoinAdapterInterface? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoCoinViewHolder {
        val cryptoView = LayoutInflater.from(context).inflate(R.layout.coins_list, parent, false)
        val holder = CryptoCoinViewHolder(cryptoView)
        return holder
    }

    override fun onBindViewHolder(holder: CryptoCoinViewHolder, position: Int) {
        val coin = cryptoCoins[position]
        holder.coinsList.setCoinsName(coin.name)
        holder.coinsList.setRankingCoin(coin.rank)
        if (coin.favorite){
            holder.coinsList.setIsFavorite()
        } else {
            holder.coinsList.setIsNotFavorite()
        }
        //click implementation
        holder.coinsList.listener = object: AccessCryptoCoinClicklListener {
            override fun setFavoriteState() {
                coin.favorite = !coin.favorite
                notifyItemChanged(holder.adapterPosition)
            }
            override fun setCardViewImplementation() {
                notifyMyActivity?.notifyActivity(coin)
            }
        }
    }

    override fun getItemCount(): Int = cryptoCoins.size

    inner class CryptoCoinViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val coinsList: AccessCryptoCoins =
            itemView.findViewById(R.id.listAccessCryptoCoin)
    }

}
interface CryptoCoinAdapterInterface{
    fun notifyActivity(coin: CryptoCoin)
}