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
    data class Student(
        val name: String,
        val age: Byte
    )

    data class Book(
        val title: String,
        val author: String,
    )

    data class Temp(
        val morning: Long,
        val afternoon: Long,
        val evening: Long
    )

    data class Weather(
        val location: String,
        val temperatures: Temp
    )

    data class Participant(
        val name: String,
        val age: Byte
    )

    data class Event(
        val event: String,
        val participants: List<Participant>
    )

    data class Author(
        val authorName: String,
        val booksWritten: Byte,
        val genres: List<String>
    )

    data class Ingredient(
        val ingredient: String,
        val quantity: Byte
    )

    data class Leves(
        val name: String,
        val ingredients: List<Ingredient>,
        val cookingTimeMinutes: Byte
    )

    //nagy
    data class Address(
        val city: String,
        val street: String,
        val zipCode: String
    )

    data class Customer(
        val customerId: Byte,
        val name: String,
        val email: String,
        val phone: String,
        val address: Address
    )

    data class Item(
        val product: Product,
        val quantity: Byte,
        val pricePerUnit: Byte
    )

    data class Product(
        val productId: String,
        val name: String,
        val category: String
    )

    data class Order(
        val orderId: String,
        val customer: Customer,
        val items: List<Item>,
        val orderStatus: String,
        val totalAmount: Long
    )

    private lateinit var OpenCalculatorButton: Button
    private lateinit var OpenGreetingButton: Button

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
    }
}