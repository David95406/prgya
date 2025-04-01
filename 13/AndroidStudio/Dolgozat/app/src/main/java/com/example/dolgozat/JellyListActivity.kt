package com.example.dolgozat

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dolgozat.adapter.JellyAdapter
import com.example.dolgozat.model.JellyBean
import com.example.dolgozat.network.JellyService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class JellyListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jelly)

        val recycylerView : RecyclerView = findViewById(R.id.jellyListRecyclerView);
        recycylerView.layoutManager = LinearLayoutManager(this)
        lifecycleScope.launch {
            try {
                val jellybeans = fetchJellybeans()
                Log.d("API valasz:", jellybeans.toString())
                if (!jellybeans.isNullOrEmpty()) {
                    // recycylerView.adapter = JellyAdapter(jellybeans)
                }
            } catch (e: Exception) {
                Log.e("Hiba, onCreate", e.message.toString())
            }
        }
    }

    private suspend fun fetchJellybeans() : List<JellyBean>? {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jellybellywikiapi.onrender.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val jellyService = retrofit.create(JellyService::class.java)
        return withContext(Dispatchers.IO) {
            try {
                val response = jellyService.getJellybeans("10")
                response.items
            } catch (e: Exception) {
                Log.e("Hiba az API kérés során", e.message.toString())
                null
            }
        }
    }


}