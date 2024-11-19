package com.example.kotlinbasics

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class WeatherActivity : AppCompatActivity() {
    private lateinit var textViewTemp: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_weather)
        textViewTemp = findViewById(R.id.textViewTemp)

        //fetchData()
    }


}