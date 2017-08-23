package com.jahnold.kotlinkats.data.network

import com.jahnold.kotlinkats.data.entities.Cat
import retrofit2.Retrofit
import rx.Observable


/**
 * Created by matthewarnold on 10/08/2017.
 */
class CatsHttp(retrofit: Retrofit) {

    private val http : CatsRestApi = retrofit.create(CatsRestApi::class.java)

    fun getCats() : Observable<Data<List<Cat>>> {

        return http
                .getCats()
                .map { response ->
                    when  {
                        response.isSuccessful -> Data.Success<List<Cat>>(response.body())
                        else -> Data.Error(DataError())
                    }
                }
    }
}