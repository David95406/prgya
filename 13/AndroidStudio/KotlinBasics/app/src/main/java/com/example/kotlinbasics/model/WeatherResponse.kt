package com.example.kotlinbasics.model

data class Main(val temp: Double)

data class WeatherResponse(
    val main: Main
)