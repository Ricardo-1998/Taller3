package com.example.monedas

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import com.bumptech.glide.Glide
import com.example.monedas.Tools.Moneda

import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.app_bar_main.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        setSupportActionBar(toolbar)
        val reciever: Moneda = intent?.extras?.getParcelable("COIN") ?: Moneda()
        init(reciever)
    }

    fun init(coin: Moneda){
        Glide.with(this)
            .load(coin.img)
            .placeholder(R.drawable.ic_launcher_background)
            .into(img_act_2)
        name_act_2.text = coin.name
        descripcion_act_2.text = coin.review
        valor_act_2.text = coin.value
        valorUS_act_2.text = coin.value_us
        pais_act_2.text = coin.country
        available_act_2.text = coin.isAvailable
    }


}
