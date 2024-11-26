package com.example.kotlinbasics.network

import android.util.Log
import com.example.kotlinbasics.model.WeatherResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import kotlin.jvm.Throws

interface WeatherService {
    @GET("data/2.5/weather")
    fun getWeather(
        @Query("q") city: String,
        @Query("appid") apiKey: String,
        @Query("units") units: String
    ): Call<WeatherResponse>

    private fun fetchData() {
        val apiKey = "ads"

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val weatherService = retrofit.create(WeatherService::class.java)
        val call = weatherService.getWeather("Tatabánya", apiKey = apiKey, units = "metric")
        call.enqueue(object: Callback<WeatherResponse> {
            override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) {
                if (response.isSuccessful) {
                    val weatherResponse = response.body()

                    if (weatherResponse != null) {
                        val weatherInfo = weatherResponse.main.temp
                        textViewTemp.text = "Hőmérséklet: $weatherInfo °C"
                    }
                }

            }

            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {

            }
        })
    }
}