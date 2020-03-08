package com.example.stonechallenge

import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

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
        val observable = RetrofitConfig().buildingService().list(chave)
        observable
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<List<ChuckResponse>> {
                override fun onSubscribe(d: Disposable?) {
                }

                override fun onComplete() {
                }

                override fun onError(e: Throwable) {
                    presenter.exibirErro(e.message)
                }

                override fun onNext(resposta: List<ChuckResponse>) {
                    presenter.exibirResultados(resposta)
                }
            })
    }

    fun fetchSearchListCategories() {
        val observable = RetrofitConfig().buildingService().listCategories()
        observable
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<List<String>> {
                override fun onSubscribe(d: Disposable?) {
                }

                override fun onComplete() {
                }

                override fun onError(e: Throwable) {
                    presenter.exibirErro(e.message)
                }

                override fun onNext(resposta: List<String>) {
                    presenter.exibirCategorias(resposta)
                }
            })
    }

    private fun fetchRespostaUnica(chave: String) {

        val observable = RetrofitConfig().buildingService().respostaUnica(chave)
        observable
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<ChuckResponse> {
                override fun onSubscribe(d: Disposable?) {
                }

                override fun onComplete() {
                }

                override fun onError(e: Throwable) {
                    presenter.exibirErro(e.message)
                }

                override fun onNext(resposta: ChuckResponse) {
                    presenter.exibirResultado(resposta)
                }
            })
    }
}