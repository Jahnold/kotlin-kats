package com.jahnold.kotlinkats.data.entities

import com.google.gson.annotations.SerializedName

/**
 * Created by matthewarnold on 07/08/2017.
 */
data class Cat(

        @SerializedName("name")
        val name: String,

        @SerializedName("desc")
        val description: String,

        @SerializedName("image")
        val imageUrl: String
)