package com.example.monedas.Adapters

import com.example.monedas.Tools.Moneda


object AppConstants{
    val dataset_saveinstance_key = "CLE"
    val MAIN_LIST_KEY = "KEY_COIN"
}
interface MyCoinAdapter {
    fun changeDataSet(newDataSet : List<Moneda>)
}