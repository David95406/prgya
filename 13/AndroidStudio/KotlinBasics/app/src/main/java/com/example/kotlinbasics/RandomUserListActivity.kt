package com.example.kotlinbasics

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinbasics.model.RandomUserResponse
import com.example.kotlinbasics.network.RandomUserService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RandomUserListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_random_users)

        fetchRandomUserList()
    }

    private fun fetchRandomUserList() {
        // Retrofit inicializálása
        val retrofit = Retrofit.Builder()
            .baseUrl("https://randomuser.me/")
            .addConverterFactory(GsonConverterFactory.create()) // JSON -> Kotlin objektum
            .build()

        val service = retrofit.create(RandomUserService::class.java)
        val call = service.getRandomUsers("3")

        call.enqueue(object : Callback<RandomUserResponse> {
            @SuppressLint("SetTextI18n")
            override fun onResponse(
                call: Call<RandomUserResponse>,
                response: Response<RandomUserResponse>
            ) {
                if (response.isSuccessful) {
                    val randomUserResponse = response.body()
                    if (randomUserResponse != null) {
                        Log.e("Ellenőrzés", randomUserResponse.toString())

                    } else {
                        Log.e("Hiba", "Üres válasz érkezett.")

                    }
                } else {
                    Log.e("Hiba", "Hiba: ${response.code()}")

                }
            }

            override fun onFailure(call: Call<RandomUserResponse>, t: Throwable) {
                Log.e("Hiba", "Hiba az API kérés során: ${t.message}")
            }
        })
    }

}