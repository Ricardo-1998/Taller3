package com.example.monedas.Adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.monedas.R
import com.example.monedas.Tools.Moneda
import kotlinx.android.synthetic.main.coin_list.view.*

class CoinAdapter(var coin: List<Moneda>, val clickListener: (Moneda) -> Unit): RecyclerView.Adapter<CoinAdapter.ViewHolder>(), MyCoinAdapter {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.coin_list, parent, false)
        return ViewHolder(view)
    }
    override fun getItemCount() = coin.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(coin[position], clickListener)

    override fun changeDataSet(newDataSet: List<Moneda>) {
        this.coin = newDataSet
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(item: Moneda, clickListener: (Moneda) -> Unit) = with(itemView){

            name_coin_list.text = item.name
            valor_coin_list.text = item.value
            valorUS_coin_list.text = item.value_us
            pais_coin_list.text = item.country
            this.setOnClickListener { clickListener(item) }
        }
    }

}