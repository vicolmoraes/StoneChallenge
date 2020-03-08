package com.example.stonechallenge

enum class Configurator {

    INSTANCE;

    fun setCleanArchitecture(activity: ActivityPadrao) {
        val presenter = Presenter()
        presenter.activity = activity

        val interactor = Interactor()
        interactor.presenter = presenter

        activity.interactor = interactor
    }
}