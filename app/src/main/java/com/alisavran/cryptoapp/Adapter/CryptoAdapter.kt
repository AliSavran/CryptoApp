package com.alisavran.cryptoapp.Adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alisavran.cryptoapp.CryptoItem
import com.alisavran.cryptoapp.R
import kotlin.random.Random

class CryptoAdapter(private val cryptoList: List<CryptoItem>) : RecyclerView.Adapter<CryptoAdapter.CryptoViewHolder>() {

    class CryptoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val cryptoName: TextView = itemView.findViewById(R.id.cryptoName)
        private val cryptoPrice: TextView = itemView.findViewById(R.id.cryptoPrice)

        fun bind(crypto: CryptoItem) {
            cryptoName.text = crypto.name
            cryptoPrice.text = "$${crypto.quote.USD.price}"

            val randomColor = getRandomColor()
            itemView.setBackgroundColor(randomColor)

        }

        private fun getRandomColor(): Int{
            val random = Random.nextInt(0,256)
            val random2 = Random.nextInt(0,256)
            val random3 = Random.nextInt(0,256)

            return Color.rgb(random,random2,random3)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.crypto_item, parent, false)
        return CryptoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return cryptoList.size
    }

    override fun onBindViewHolder(holder: CryptoViewHolder, position: Int) {
        val crypto = cryptoList[position]
        holder.bind(crypto)
    }
}