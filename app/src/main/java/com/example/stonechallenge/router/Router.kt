package com.example.stonechallenge.router

import com.example.stonechallenge.interactor.Interactor
import com.example.stonechallenge.presenter.Presenter
import com.example.stonechallenge.view.ActivityPadrao

enum class Router {

    INSTANCE;

    fun setCleanArchitecture(activity: ActivityPadrao) {
        val presenter = Presenter()
        presenter.activity = activity

        val interactor = Interactor()
        interactor.presenter = presenter

        activity.interactor = interactor
    }
}