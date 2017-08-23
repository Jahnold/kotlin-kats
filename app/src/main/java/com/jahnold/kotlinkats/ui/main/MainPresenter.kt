package com.jahnold.kotlinkats.ui.main

import com.jahnold.kotlinkats.data.network.Data
import com.jahnold.kotlinkats.data.repositories.CatsRepository
import com.jahnold.kotlinkats.ui.common.Presenter
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by matthewarnold on 05/08/2017.
 */
class MainPresenter(private val catsRepository: CatsRepository) : Presenter<MainView>() {

    fun init() {
        subscribeToCats()
    }

    private fun subscribeToCats() {

        val s : Subscription = catsRepository
                .getCats()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { data ->
                            when (data) {
                                is Data.Loading -> view?.setLoadingView()
                                is Data.Success -> view?.setContentView(data.result)
                                is Data.Error -> view?.setErrorView()
                            }
                        },
                        { it.printStackTrace() }
                )
    }
}