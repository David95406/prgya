package com.example.kotlinbasics

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinbasics.adapter.UserAdapter
import com.example.kotlinbasics.model.User

class UserListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_users)

        val users = listOf(
            User("Kovács Péter", "peterkovacs@email.com", R.drawable.user),
            User("Nagy János", "nagyjanos@email.com", R.drawable.user),
            User("Szabó István", "istvanszabo@email.com", R.drawable.user),
            User("Tóth Anna", "annatoth@email.com", R.drawable.user),
            User("Varga Katalin", "katalinvarga@email.com", R.drawable.user),
            User("Horváth László", "laszlohorvath@email.com", R.drawable.user),
            User("Kiss Zoltán", "zoltankiss@email.com", R.drawable.user),
            User("Molnár Gábor", "gabormolnar@email.com", R.drawable.user),
            User("Németh Tamás", "tamasnemeth@email.com", R.drawable.user),
            User("Farkas Éva", "evafarkas@email.com", R.drawable.user),
            User("Balogh Attila", "attilabalogh@email.com", R.drawable.user),
            User("Papp László", "laszlopapp@email.com", R.drawable.user),
            User("Tóth Béla", "belatoth@email.com", R.drawable.user),
            User("Kovács László", "laszlokovacs@email.com", R.drawable.user),
            User("Szabó Katalin", "katalinszabo@email.com", R.drawable.user),
            User("Nagy Éva", "evanagy@email.com", R.drawable.user),
            User("Varga Péter", "petervarga@email.com", R.drawable.user)
        )

        val recyclerView : RecyclerView = findViewById(R.id.userRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = UserAdapter(users)

    }//onCreate



}