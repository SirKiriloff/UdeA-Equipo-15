package com.kirilcorp.cityview

import com.google.gson.annotations.SerializedName

data class PoiModel(
    @SerializedName("id")
    val poiId: Int,

    @SerializedName("name")
    val poiName: String,

    @SerializedName("description")
    val poiDescription: String,

    @SerializedName("info")
    val poiInfo: String,

    @SerializedName("score")
    val poiScore: String?,

    @SerializedName("population")
    val poiPopulation: String,

    @SerializedName("temperature")
    val poiTemperature: String,

    @SerializedName("image")
    val poiImage: String,

    @SerializedName("location")
    val poiLocation: ArrayList<Double>?
)

//http://my-json-server.typicode.com/HectorDevOne/fake_db/pois

//{
//    "id": 1,
//    "name": "Avarua",
//    "description": "Is the national capital of the Cook Islands",
//    "info": "Avarua (meaning \"Two Harbours\" in Cook Islands Māori) is a town and district in the north of the island of Rarotonga, and is the national capital of the Cook Islands. The town is served by Rarotonga International Airport (IATA Airport Code: RAR) and Avatiu Harbour.",
//    "score": "4.5",
//    "population": "4,906",
//    "temperature": "28.8 ˚C",
//    "image": "https://en.wikipedia.org/wiki/Avarua#/media/File:Avarua,_february_2006.jpg",
//    "location": [
//    -21.206944,
//    -159.770833
//    ]
//},