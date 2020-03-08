package com.example.stonechallenge


import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface ChuckServices {

    @GET("{tag}")
    fun list(@Path("tag") tag: String?): Observable<List<ChuckResponse>>

    @GET(Constants.LIST_ALL_CATEGORIES)
    fun listCategories(): Observable<List<String>>

    @GET("{tag}")
    fun respostaUnica(@Path("tag") tag: String?): Observable<ChuckResponse>
}