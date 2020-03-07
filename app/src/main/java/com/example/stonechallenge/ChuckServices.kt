package com.example.stonechallenge

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ChuckServices {
    @GET("{tag}")
    fun list(@Path("tag") tag: String?): Call<ChuckResponse>
}