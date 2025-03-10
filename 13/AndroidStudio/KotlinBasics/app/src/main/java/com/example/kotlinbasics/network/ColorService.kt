package com.example.kotlinbasics.network

import com.example.kotlinbasics.model.ColorResponse
import retrofit2.Call
import retrofit2.http.GET

interface ColorService {
    @GET("unknown")
    fun getColors(): Call<ColorResponse>
}