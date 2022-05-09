package com.example.kotlin_api.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kotlin_api.databinding.ActivityMainBinding
import com.example.kotlin_api.model.cryptoModel
import com.example.kotlin_api.service.CryptoAPI
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    //https://api.nomics.com/v1
    //51893bf8cf16c556823cdb9342309a0680fa93b5

    private  val BASE_URL = "https://api.nomics.com/v1/"
    private var cryptoList: ArrayList<cryptoModel>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        loadData()


    }

    fun loadData(){

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(CryptoAPI::class.java)
        val call = service.getData()


        call.enqueue(object : Callback<List<cryptoModel>> {
            override fun onResponse(
                call: Call<List<cryptoModel>>,
                response: Response<List<cryptoModel>>
            ) {
                println(response)
                if (response.isSuccessful){
                    response.body()?.let {
                        cryptoList = ArrayList(it)
                        for (deneme in cryptoList!!){
                            println(deneme.id)
                            println(deneme.price)
                        }
                    }
                }
                else{
                    println("response başarılı değil")
                }
            }

            override fun onFailure(call: Call<List<cryptoModel>>, t: Throwable) {
                t.printStackTrace()
            }

        })


    }


}