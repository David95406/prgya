package com.example.dolgozat.network

import com.example.dolgozat.model.JellyResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface JellyService {
    @GET("api/Beans/") // !
    suspend fun getJellybeans(
        @Query("items") results: String
    ): JellyResponse
}
