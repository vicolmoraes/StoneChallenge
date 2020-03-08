package com.example.stonechallenge

class Presenter {

    lateinit var activity: ActivityPadrao

    fun exibirErro(resposta: String?) {
        activity.exibirErro(resposta)
    }

    fun exibirResultado(resposta: ChuckFact) {
        activity.exibirResultado(resposta)
    }

    fun exibirResultados(resposta: List<ChuckFact>) {
        activity.listarRespostas(resposta)
    }

    fun exibirCategorias(resposta: List<String>) {
        activity.listarCategorias(resposta)
    }
}