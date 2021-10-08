package com.kirilcorp.cityview

import com.google.gson.annotations.SerializedName

data class Sities (

    @SerializedName("name")
    val name: String,

    @SerializedName("description")
    val descriptio: String,

    @SerializedName("score")
    val score: String,

    @SerializedName("image")
    var image: String
)
