package com.example.stonechallenge

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConfig {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.chucknorris.io/jokes/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun buildingService(): ChuckServices {
        return retrofit.create(ChuckServices::class.java)
    }
}