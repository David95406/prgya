package com.example.kotlinbasics.model

data class Main(
    val temp: Double,
    val humidity: Int
)

data class Wind(
    val speed: Double,
    val deg: Double,
    val gust: Double
)

data class WeatherResponse(
    val main: Main,
    val wind: Wind
)