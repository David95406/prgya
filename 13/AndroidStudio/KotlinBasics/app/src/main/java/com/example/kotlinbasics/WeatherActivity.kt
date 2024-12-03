package com.example.kotlinbasics

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinbasics.model.WeatherResponse
import com.example.kotlinbasics.network.WeatherService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherActivity : AppCompatActivity() {

    private lateinit var textViewTemp: TextView
    private val apiKey = "ec792de84629c5a331b74891dfba8476"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_weather)

        textViewTemp = findViewById(R.id.textViewTemp)

        fetchWeatherData()
    }

    private fun fetchWeatherData() {
        // Retrofit inicializálása
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(WeatherService::class.java)
        val call = service.getWeather("Tatabánya", apiKey, "metric")

        call.enqueue(object : Callback<WeatherResponse> {
            override fun onResponse(
                call: Call<WeatherResponse>,
                response: Response<WeatherResponse>
            ) {
                if (response.isSuccessful) {
                    val weatherResponse = response.body()
                    if (weatherResponse != null) {
                        val temperature = weatherResponse.main.temp
                        textViewTemp.text = "$temperature °C"
                    } else {
                        textViewTemp.text = "Üres válasz érkezett."
                    }
                } else {
                    textViewTemp.text = "Hiba: ${response.code()}"
                }
            }

            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                Log.e("Hiba", "Hiba az API kérés során: ${t.message}")
                textViewTemp.text = "Hiba történt az adatlekéréskor."
            }
        })
    }
}