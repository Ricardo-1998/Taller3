package com.example.monedas.fragments

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.monedas.Adapters.AppConstants
import com.example.monedas.Adapters.CoinAdapter
import com.example.monedas.Adapters.MyCoinAdapter
import com.example.monedas.R
import com.example.monedas.Tools.Moneda
import kotlinx.android.synthetic.main.coin_list_fragment.*
import kotlinx.android.synthetic.main.coin_list_fragment.view.*
import java.lang.ClassCastException

class mainList : Fragment() {
    private lateinit var  coins :ArrayList<Moneda>
    private lateinit var coinsAdapter : MyCoinAdapter
    var listenerTool :  SearchNewMovieListener? = null

    companion object {
        fun newInstance(dataset : ArrayList<Moneda>): mainList{
            val newFragment = mainList()
            newFragment.coins = dataset
            return newFragment
        }
    }

    interface SearchNewMovieListener{
        fun managePortraitItemClick(coin: Moneda)

        fun manageLandscapeItemClick(coin: Moneda)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.coin_list_fragment, container, false)

        if(savedInstanceState != null) coins = savedInstanceState.getParcelableArrayList<Moneda>(AppConstants.MAIN_LIST_KEY)!!

        initRecyclerView(resources.configuration.orientation, view)

        return view
    }

    fun initRecyclerView(orientation:Int, container:View){
        val linearLayoutManager = LinearLayoutManager(this.context)

        if(orientation == Configuration.ORIENTATION_PORTRAIT){
            coinsAdapter = CoinAdapter(coins, { movie:Moneda->listenerTool?.managePortraitItemClick(movie)})
            container.rv_coins_list.adapter = coinsAdapter as CoinAdapter
        }
        if(orientation == Configuration.ORIENTATION_LANDSCAPE){
            coinsAdapter = CoinAdapter(coins, {movie:Moneda->listenerTool?.manageLandscapeItemClick(movie)})
            container.rv_coins_list.adapter = coinsAdapter as CoinAdapter
        }

        container.rv_coins_list.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(this.context,2)
        }
    }

    fun updateCoinsAdapter(coinsList: ArrayList<Moneda>){ coinsAdapter.changeDataSet(coinsList) }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is SearchNewMovieListener) {
            listenerTool = context
        } else {
            throw ClassCastException("Se necesita una implementacion de  la interfaz")
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putParcelableArrayList(AppConstants.MAIN_LIST_KEY, coins)
        super.onSaveInstanceState(outState)
    }

    override fun onDetach() {
        super.onDetach()
        listenerTool = null
    }

}
