package com.example.kotlinbasics.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinbasics.R
import com.example.kotlinbasics.adapter.ColorAdapter
import com.example.kotlinbasics.model.ColorResponse
import com.example.kotlinbasics.network.ColorService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ColorListActivity : AppCompatActivity() {
    private lateinit var colorAdapter: ColorAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color_list)

        recyclerView = findViewById(R.id.colorListRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)


        val retrofit = Retrofit.Builder()
            .baseUrl("https://reqres.in/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(ColorService::class.java)
        service.getColors().enqueue(object : Callback<ColorResponse> {

            override fun onResponse(call: Call<ColorResponse>, response: Response<ColorResponse>) {
                if (response.isSuccessful) {
                    val colors = response.body()?.data ?: emptyList()
                    colorAdapter = ColorAdapter(colors)
                    recyclerView.adapter = colorAdapter
                } else {
                    Log.e("ColorListActivity", "Error: ${response.errorBody()}")
                }
            }

            override fun onFailure(call: Call<ColorResponse>, t: Throwable) {
                Log.e("ColorListActivity", "Error: ${t.message}")
            }

        })
    } // onCreate
}