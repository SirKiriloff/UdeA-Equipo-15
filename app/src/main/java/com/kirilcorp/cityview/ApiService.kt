package com.kirilcorp.cityview

import retrofit2.http.GET

interface ApiService {

    @GET("pois")
    suspend fun requestPois(): List<PoiModel>

//    @GET("/users/{id}")
//    suspend fun requestUser(@Path(value = "id") userId: Int): User
//
//    @GET("/comments")
//    suspend fun requestComments(@Query(value = "postId") userId: Int): List<Comment>
}