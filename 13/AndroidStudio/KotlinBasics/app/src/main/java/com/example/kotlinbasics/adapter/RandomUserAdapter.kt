package com.example.kotlinbasics.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinbasics.R
import com.example.kotlinbasics.model.RUser

class RandomUserAdapter(private val userList: List<RUser>) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    class RandomUserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val profileImage: ImageView = itemView.findViewById(R.id.image_icon)
        val nameText: TextView = itemView.findViewById(R.id.user_name)
        val emailText: TextView = itemView.findViewById(R.id.user_email)
        val countryText: TextView = itemView.findViewById(R.id.user_country)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RandomUserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return RandomUserViewHolder(view)
    }

    override fun onBindViewHolder(holder: RandomUserAdapter.RandomUserViewHolder, position: Int) {
        val user = userList[position]
        holder.nameText.text = user.name.first + " " + user.name.last
        holder.emailText.text = user.email
        holder.countryText.text = user.location.country
    }

    override fun getItemCount(): Int {
        return userList.size
    }



}