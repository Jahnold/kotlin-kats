package com.jahnold.kotlinkats.ui.common

/**
 * Created by matthewarnold on 07/08/2017.
 */
open class Presenter<V> {

    var view: V? = null

    protected fun view() : V? {
        return view
    }

    fun bindView(view : V) {

        this.view = view
    }

    fun unbindView(view : V) {

        this.view = null
    }

}