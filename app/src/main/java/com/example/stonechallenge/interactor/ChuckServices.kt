package com.example.stonechallenge.interactor


import com.example.stonechallenge.Constants
import com.example.stonechallenge.entity.ChuckFact
import com.example.stonechallenge.entity.ChuckFacts
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Url

interface ChuckServices {

    @GET()
    fun list(@Url tag: String?): Observable<ChuckFacts>

    @GET(Constants.LIST_ALL_CATEGORIES)
    fun listCategories(): Observable<List<String>>

    @GET()
    fun respostaUnica(@Url tag: String?): Observable<ChuckFact>
}