package com.example.kotlinbasics

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Phone
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var OpenCalculatorButton: Button
    private lateinit var OpenGreetingButton: Button
    private lateinit var OpenWeatherButton: Button
    private lateinit var OpenUserListButton: Button

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
    }

}