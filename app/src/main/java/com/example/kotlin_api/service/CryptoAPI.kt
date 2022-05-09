package com.example.kotlin_api.service

import com.example.kotlin_api.model.cryptoModel
import retrofit2.Call
import retrofit2.http.GET

interface CryptoAPI {


    //https://api.nomics.com/v1
    //curl "https://api.nomics.com/v1/currencies/ticker?key=your-key-here&ids=BTC,ETH,XRP&interval=1d,30d&convert=EUR&platform-currency=ETH&per-page=100&page=1"
    //51893bf8cf16c556823cdb9342309a0680fa93b5


    @GET ("currencies/ticker?key=51893bf8cf16c556823cdb9342309a0680fa93b5&ids=BTC,ETH,XRP&interval=1d,30d&convert=EUR&platform-currency=ETH&per-page=100&page=1")
    fun getData(): Call<List<cryptoModel>>

}