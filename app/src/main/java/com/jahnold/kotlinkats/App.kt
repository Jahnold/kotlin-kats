package com.jahnold.kotlinkats

import android.app.Application
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory



/**
 * Created by matthewarnold on 11/08/2017.
 */
class App : Application() {

    private lateinit var retrofit : Retrofit

    override fun onCreate() {

        super.onCreate()
        instance = this
        initRetrofit()
    }

    fun getRetrofit() : Retrofit {
        return retrofit
    }

    private fun initRetrofit() {

        val okHttpClient = OkHttpClient.Builder()
                .build()

        val gson = GsonBuilder()
                .setLenient()
                .create()

        retrofit = Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("http://www.mocky.io/v2/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
    }

    companion object {
        lateinit var instance : App
    }
}