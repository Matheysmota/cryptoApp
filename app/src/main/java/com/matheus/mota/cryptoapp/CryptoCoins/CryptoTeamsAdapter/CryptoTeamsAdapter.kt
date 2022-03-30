package com.matheus.mota.cryptoapp.CryptoCoins.CryptoTeamsAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.matheus.mota.cryptoapp.CryptoCoins.AccessCryptoTeams
import com.matheus.mota.cryptoapp.R

class CryptoTeamsAdapter(private val context: Context, private val cryptoTeams: MutableList<CryptoTeams>): RecyclerView.Adapter<CryptoTeamsAdapter.CryptoTeamsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoTeamsViewHolder {
        val cryptoView = LayoutInflater.from(context).inflate(R.layout.teams_list, parent, false)
        val holder = CryptoTeamsViewHolder(cryptoView)
        return holder
    }

    override fun onBindViewHolder(holder: CryptoTeamsViewHolder, position: Int) {
        val teams = cryptoTeams[position]
        holder.teamsList.setTittle(teams.tittle)
        holder.teamsList.setSubTittle(teams.subTittle)
        teams.line?.let { holder.teamsList.setLine(it) }
    }

    override fun getItemCount(): Int = cryptoTeams.size

    inner class CryptoTeamsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val teamsList = itemView.findViewById<AccessCryptoTeams>(R.id.listAccessCryptoTeams)
    }
}
