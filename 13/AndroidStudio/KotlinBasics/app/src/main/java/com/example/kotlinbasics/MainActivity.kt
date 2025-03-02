package com.example.kotlinbasics

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinbasics.ui.ColorListActivity

class MainActivity : AppCompatActivity() {
    private lateinit var OpenCalculatorButton: Button
    private lateinit var OpenGreetingButton: Button
    private lateinit var OpenWeatherButton: Button
    private lateinit var OpenUserListButton: Button
    private lateinit var OpenRandomUserListButton: Button
    private lateinit var OpenColorListButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        OpenCalculatorButton = findViewById(R.id.OpenCalculatorButton)
        OpenCalculatorButton.setOnClickListener() {
            val intent = Intent(this, CalculatorActivity::class.java)
            startActivity(intent)
        }

        OpenGreetingButton = findViewById(R.id.OpenGreetingButton)
        OpenGreetingButton.setOnClickListener() {
            val intent = Intent(this, GreetingActivity::class.java)
            startActivity(intent)
        }

        OpenWeatherButton = findViewById(R.id.OpenWeatherButton)
        OpenWeatherButton.setOnClickListener() {
            val intent = Intent(this, WeatherActivity::class.java)
            startActivity(intent)
        }

        OpenUserListButton = findViewById(R.id.OpenUserListButton)
        OpenUserListButton.setOnClickListener() {
            val intent = Intent(this, UserListActivity::class.java)
            startActivity(intent)
        }

        OpenRandomUserListButton = findViewById(R.id.OpenRandomUserListButton)
        OpenRandomUserListButton.setOnClickListener() {
            val intent = Intent(this, RandomUserListActivity::class.java)
            startActivity(intent)
        }

        OpenColorListButton = findViewById(R.id.OpenColorListButton)
        OpenColorListButton.setOnClickListener() {
            val intent = Intent(this, ColorListActivity::class.java)
            startActivity(intent)
        }

    }

}