package com.example.monedas.Network

import android.net.Uri
import android.util.Log
import java.io.IOException
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL
import java.util.*

class NetworkUtils {
    val BASEURL = "http://api-coin.herokuapp.com/coin"
    fun buildtUrl() : URL {
        val builtUri = Uri.parse(BASEURL)
                .buildUpon()
                .build()

        return try {
            URL(builtUri.toString())
        }catch (e : MalformedURLException){
            URL("")
        }
    }
    fun buildtSearchUrl(country:String) : URL {
        val builtUri = Uri.parse(BASEURL)
                .buildUpon()
                .appendPath(country)
                .build()

        return try {
            URL(builtUri.toString())
        }catch (e : MalformedURLException){
            URL("")
        }
    }

    @Throws(IOException::class)
    fun getResponseFromHttpUrl(url: URL):String{
        val urlConnection = url.openConnection() as HttpURLConnection
        try {
            val `in` = urlConnection.inputStream

            val scanner = Scanner(`in`)
            scanner.useDelimiter("\\A")

            val hasInput = scanner.hasNext()
            return if(hasInput){
                scanner.next()
            }else{
                ""
            }
        }finally {
            urlConnection.disconnect()
        }
    }

}