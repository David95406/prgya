package com.example.kotlinbasics

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CalculatorActivity : AppCompatActivity() {
    private lateinit var EditTextANum: EditText
    private lateinit var EditTextBNum: EditText
    private lateinit var TextViewResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calculator)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


    }

    fun addNumbers() {
        try {
            EditTextANum = findViewById(R.id.EditTextANum)
            EditTextBNum = findViewById(R.id.EditTextBNum)
            TextViewResult = findViewById(R.id.TextViewResult)
        } catch (e : Exception) {
            TextViewResult.setText("baj: " + e.message)
        }


        /*
        var eredmeny : String =
            (EditTextANum.text.toString().toDouble() + EditTextBNum.text.toString()
                .toDouble()).toString()
         */



    }
}