package com.example.kotlinbasics

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinbasics.adapter.RandomUserAdapter
import com.example.kotlinbasics.model.RUser
import com.example.kotlinbasics.network.RandomUserService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RandomUserListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random_users)

        val recycylerView : RecyclerView = findViewById(R.id.randomUserListRecyclerView);
        recycylerView.layoutManager = LinearLayoutManager(this)
        lifecycleScope.launch {
            try {
                val randomUsers = fetchRandomUserList()
                if(!randomUsers.isNullOrEmpty()){
                    recycylerView.adapter = RandomUserAdapter(randomUsers)
                }else{
                    Log.e("Hiba", "A recyclerview nem található")
                }
                recycylerView.adapter = randomUsers?.let { RandomUserAdapter(it) }
            } catch (e: Exception) {
                Log.e("Hiba", "Hiba az letoltesben")
            }
        }
    }

    private suspend fun fetchRandomUserList(): List<RUser>? {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://randomuser.me/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val randomUserService = retrofit.create(RandomUserService::class.java)
        return withContext(Dispatchers.IO) {
            try {
                val response = randomUserService.getRandomUsers("10")
                response.results
            } catch (e: Exception) {
                Log.e("Hiba", "Hiba az API kérés során")
                null
            }
        };
    }
}