package com.jahnold.kotlinkats.ui.main

import com.jahnold.kotlinkats.data.entities.Cat

/**
 * Created by matthewarnold on 05/08/2017.
 */
interface MainView {

    fun setContentView(cats: List<Cat>)
    fun setLoadingView()
    fun setErrorView()
}