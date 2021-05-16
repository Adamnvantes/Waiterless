package com.example.waiterless.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("http://10.0.2.2/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api : WaiterlessAPI by lazy{
        retrofit.create(WaiterlessAPI::class.java)
    }
}