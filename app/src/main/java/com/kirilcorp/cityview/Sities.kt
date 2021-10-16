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
    var image: String,

    @SerializedName("temperature")
    val temperature: String,

    @SerializedName("schedule")
    val schedule: String,

    @SerializedName("price")
    val price: String,

    @SerializedName("ubication")
    var ubication: String
)
