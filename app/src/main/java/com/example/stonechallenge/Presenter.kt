package com.example.stonechallenge

class Presenter {

    lateinit var mainActivity: MainActivity

    fun exibirErro(resposta: String?) {
        mainActivity.exibirErro(resposta)
    }

    fun exibirResultado(resposta: ChuckResponse) {
        mainActivity.exibirResultado(resposta)
    }

    fun exibirResultados(resposta: List<ChuckResponse>) {
        mainActivity.listarRespostas(resposta)
    }

    fun exibirCategorias(resposta: List<String>) {
        mainActivity.listarCategorias(resposta)
    }
}