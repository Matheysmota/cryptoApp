package com.matheus.mota.cryptoapp.cryptoHome.CryptoCoinsAdapter
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.matheus.mota.cryptoapp.cryptoHome.AccessCryptoCoins
import com.matheus.mota.cryptoapp.R
import com.matheus.mota.cryptoapp.cryptoHome.AccessCryptoCoinClicklListener
import com.matheus.mota.cryptoapp.cryptoHome.startCoinInfo
import com.matheus.mota.cryptoapp.cryptoInfo.CryptoCoinInfoActivity


open class CryptoCoinAdapter(private val context: Context, private val cryptoCoins: MutableList<CryptoCoin>): RecyclerView.Adapter<CryptoCoinAdapter.CryptoCoinViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoCoinViewHolder {
        val cryptoView = LayoutInflater.from(context).inflate(R.layout.coins_list, parent, false)
        val holder = CryptoCoinViewHolder(cryptoView)
        return holder
    }

    override fun onBindViewHolder(holder: CryptoCoinViewHolder, position: Int) {
        val coin = cryptoCoins[position]
        holder.coinsList.setCoinsName(coin.cryptoName)
        holder.coinsList.setRankingCoin(coin.ranking)
        if (coin.favorite){
            holder.coinsList.setIsFavorite()
        } else {
            holder.coinsList.setIsNotFavorite()
        }
        holder.coinsList.listener = object: AccessCryptoCoinClicklListener {
            override fun setFavoriteState() {
                coin.favorite = !coin.favorite
                notifyItemChanged(holder.adapterPosition)
            }

            override fun setCardViewImplementation() {
                startCoinInfo(context, coin)
            }
        }
    }

    override fun getItemCount(): Int = cryptoCoins.size

    inner class CryptoCoinViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val coinsList: AccessCryptoCoins =
            itemView.findViewById<AccessCryptoCoins>(R.id.listAccessCryptoCoin)
    }

}
