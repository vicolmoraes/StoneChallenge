package com.example.stonechallenge

interface ActivityPadrao {
    var interactor: Interactor
    fun exibirErro(resposta: String?) {
    }

    fun exibirResultado(resposta: ChuckFact) {
    }

    fun listarRespostas(resposta: List<ChuckFact>) {
    }

    fun listarCategorias(resposta: List<String>) {
    }
}