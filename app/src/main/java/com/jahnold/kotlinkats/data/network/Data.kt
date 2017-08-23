package com.jahnold.kotlinkats.data.network



/**
 * Created by matthewarnold on 10/08/2017.
 */
sealed class Data<out T> {

    object Loading : Data<Nothing>()
    data class Success<out T>(val result : T) : Data<T>()
    data class Error(val error: DataError) : Data<Nothing>()
}