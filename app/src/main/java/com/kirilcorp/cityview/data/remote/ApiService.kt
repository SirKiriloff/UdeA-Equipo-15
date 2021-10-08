package com.kirilcorp.cityview.data.remote

import retrofit2.http.GET
import com.kirilcorp.cityview.Sities


interface ApiService {

    @GET("pois")
    suspend fun requestPois(): List<Sities>
}