package com.example.kotlinbasics

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.getSystemService
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var EditTextNameInput: EditText
    private lateinit var ButtonSubmit: Button
    private lateinit var TextViewResult: TextView
    private lateinit var OpenCalculatorButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/

        //UI elemek inicializalasa
        EditTextNameInput = findViewById(R.id.EditTextNameInput)
        ButtonSubmit = findViewById(R.id.ButtonSubmit)
        TextViewResult = findViewById(R.id.TextViewResult)
        OpenCalculatorButton = findViewById(R.id.OpenCalculatorButton)

        ButtonSubmit.setOnClickListener() {
            val name = EditTextNameInput.text.toString()
            if (name.isNotEmpty()) {
                /*if (name.length <= 4) {
                    TextViewResult.text = "Hello $name!, jó rövid neved van!"
                } else if (name.length == 5) {
                    TextViewResult.text = "Hello $name!, jó neved van!"
                } else {
                    TextViewResult.text = "Hello $name!, hogy lehet ilyen hosszú neved?"
                }*/
                val greetingText = when {
                    name.length <= 4 -> "Hello $name!, jó rövid neved van!"
                    name.length == 5 -> "Hello $name!, jó neved van!"
                    else -> "Hello $name!, jó hosszú neved?"
                }
                TextViewResult.text = greetingText

                EditTextNameInput.text.clear()

                //hide keyboard
                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(EditTextNameInput.windowToken, 0)
            } else {
                TextViewResult.text = "Szép munka!"
                Toast.makeText(this, "Kérem adjon meg egy nevet!", Toast.LENGTH_SHORT).show()
            }
        }


        OpenCalculatorButton.setOnClickListener() {
            val intent = Intent(this, CalculatorActivity::class.java)
            startActivity(intent)
        }


    }//ONCREATE

}