package com.jahnold.kotlinkats.data.repositories

import com.jahnold.kotlinkats.data.entities.Cat
import com.jahnold.kotlinkats.data.network.CatsHttp
import com.jahnold.kotlinkats.data.network.Data
import rx.Observable



/**
 * Created by matthewarnold on 10/08/2017.
 */
class CatsRepository(private val http: CatsHttp) {

    fun getCats() : Observable<Data<List<Cat>>> {

        return http
                .getCats()
                .startWith(Data.Loading)
    }
}