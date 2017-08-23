package com.jahnold.kotlinkats.data.network

import com.jahnold.kotlinkats.data.entities.Cat
import retrofit2.Response
import retrofit2.http.GET
import rx.Observable


/**
 * Created by matthewarnold on 10/08/2017.
 */
interface CatsRestApi {

    @GET("58fcfef20f00004c21513695")
    fun getCats(): Observable<Response<List<Cat>>>
}