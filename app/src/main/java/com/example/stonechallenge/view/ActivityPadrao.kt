package com.example.stonechallenge.view

import com.example.stonechallenge.entity.ChuckFact
import com.example.stonechallenge.interactor.Interactor

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