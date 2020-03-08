package com.example.stonechallenge.interactor

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.Retrofit

import retrofit2.converter.jackson.JacksonConverterFactory

class RetrofitConfig {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.chucknorris.io/jokes/")
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(JacksonConverterFactory.create())
        .build()

    fun buildingService(): ChuckServices {
        return retrofit.create(ChuckServices::class.java)
    }
}