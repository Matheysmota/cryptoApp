package com.matheus.mota.cryptoapp.ui.cryptoInfo.CryptoTeamsAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.matheus.mota.cryptoapp.ui.cryptoInfo.AccessCryptoTeams
import com.matheus.mota.cryptoapp.R
import com.matheus.mota.cryptoapp.model.coinInfo.Team

class CryptoTeamsAdapter(private val context: Context, private val cryptoTeams: MutableList<Team>): RecyclerView.Adapter<CryptoTeamsAdapter.CryptoTeamsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoTeamsViewHolder {
        val cryptoView = LayoutInflater.from(context).inflate(R.layout.teams_list, parent, false)
        val holder = CryptoTeamsViewHolder(cryptoView)
        return holder
    }

    override fun onBindViewHolder(holder: CryptoTeamsViewHolder, position: Int) {
        val teams = cryptoTeams[position]
        holder.teamsList.setTittle(teams.name)
        holder.teamsList.setSubTittle(teams.position)
        teams.line?.let { holder.teamsList.setLine(it) }
    }

    override fun getItemCount(): Int = cryptoTeams.size

    inner class CryptoTeamsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val teamsList = itemView.findViewById<AccessCryptoTeams>(R.id.listAccessCryptoTeams)
    }
}
