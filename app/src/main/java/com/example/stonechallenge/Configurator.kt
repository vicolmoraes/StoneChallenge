package com.example.stonechallenge

enum class Configurator {

    INSTANCE;

    fun setCleanArchitecture(mainActivity: MainActivity) {
        val presenter = Presenter()
        presenter.mainActivity = mainActivity

        val interactor = Interactor()
        interactor.presenter = presenter

        mainActivity.interactor = interactor
    }
}