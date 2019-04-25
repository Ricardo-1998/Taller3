package com.example.monedas.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.monedas.R
import com.example.monedas.Tools.Moneda
import kotlinx.android.synthetic.main.fragment_main_content.view.*

class mainContent : Fragment() {
    var coin = Moneda()

    companion object {
        fun newInstance(coin: Moneda): mainContent{
            val newFragment = mainContent()
            newFragment.coin = coin
            return newFragment
        }
    }

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_main_content, container, false)
        bindData(view)
        return view
    }

    fun bindData(view: View){
        view.name_fragment_main_content.text = coin.name
        view.descripcion_fragment_main_content.text = coin.review
        view.valor_fragment_main_content.text = coin.value
        view.valorUS_fragment_main_content.text = coin.value_us
        view.pais_fragment_main_content.text = coin.country
        view.available_fragment_main_content.text = coin.isAvailable
        Glide.with(view).load(coin.img)
            .placeholder(R.drawable.ic_launcher_background)
            .into(view.img_fragment_main_content)
    }

}
