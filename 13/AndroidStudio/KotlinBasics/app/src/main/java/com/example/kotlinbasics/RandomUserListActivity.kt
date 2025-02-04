package com.example.kotlinbasics

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinbasics.network.RandomUserService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RandomUserListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_random_users)

        fetchRandomUserList()
    }

    private suspend fun fetchRandomUserList() {
        // Retrofit inicializálása
        val retrofit = Retrofit.Builder()
            .baseUrl("https://randomuser.me/")
            .addConverterFactory(GsonConverterFactory.create()) // JSON -> Kotlin objektum
            .build()

        val service = retrofit.create(RandomUserService::class.java)
        val RandomUserService = retrofit.create(RandomUserService::class.java)
        return withContext(Dispatchers.IO) {
            try {
                val response = RandomUserService.getRandomUsers("10")
                response.result
            } catch (e: Exception) {
                Log.e("RandomUserListActivity", "Error fetching random users", e)
            }
        }


    }

}