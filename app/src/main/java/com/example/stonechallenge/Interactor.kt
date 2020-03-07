package com.example.stonechallenge

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Interactor {
    lateinit var presenter: Presenter
    fun fetchSearchRandom() {
        fetchRespostaUnica(Constants.RANDOM)
    }

    fun fetchSearchCategorie(categoria: String) {
        fetchRespostaUnica(Constants.SEARCH_CATEGORIE + categoria)
    }

    fun fetchSearchText(texto: String) {
        fetch(Constants.SEARCH_TEXT + texto)
    }

    private fun fetch(chave: String) {
        val call = RetrofitConfig().buildingService().list(chave)
        call.enqueue(object : Callback<List<ChuckResponse>?> {
            override fun onResponse(
                call: Call<List<ChuckResponse>?>?,
                response: Response<List<ChuckResponse>?>?
            ) {
                response?.body()?.let {
                    val resposta: List<ChuckResponse> = it
                    presenter.exibirResultados(resposta)
                }
            }

            override fun onFailure(
                call: Call<List<ChuckResponse>?>?,
                t: Throwable?
            ) {
                presenter.exibirErro(t?.message)
            }
        })
    }

    fun fetchSearchListCategories() {
        val call = RetrofitConfig().buildingService().listCategories()
        call.enqueue(object : Callback<List<String>?> {
            override fun onResponse(
                call: Call<List<String>?>?,
                response: Response<List<String>?>?
            ) {
                response?.body()?.let {
                    val resposta: List<String> = it
                    presenter.exibirCategorias(resposta)
                }
            }

            override fun onFailure(
                call: Call<List<String>?>?,
                t: Throwable?
            ) {
            }
        })
    }

    private fun fetchRespostaUnica(chave: String) {
        val call = RetrofitConfig().buildingService().respostaUnica(chave)
        call.enqueue(object : Callback<ChuckResponse> {
            override fun onResponse(
                call: Call<ChuckResponse>?,
                response: Response<ChuckResponse>?
            ) {
                response?.body()?.let {
                    val resposta: ChuckResponse = it
                    presenter.exibirResultado(resposta)
                }
            }

            override fun onFailure(
                call: Call<ChuckResponse>?,
                t: Throwable?
            ) {
                presenter.exibirErro(t?.message)
            }
        })
    }
}