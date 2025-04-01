package com.example.dolgozat.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dolgozat.R
import com.example.dolgozat.model.JellyBean

class JellyAdapter(private val jellybeans: List<JellyBean>) : RecyclerView.Adapter<JellyAdapter.JellyViewHolder>() {
    class JellyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val flavorName: TextView = itemView.findViewById(R.id.flavorNameTextView)
        val description: TextView = itemView.findViewById(R.id.descriptionTextView)
        val backgroundColor: TextView = itemView.findViewById(R.id.backgroundColorTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JellyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.jelly_item, parent, false)
        return JellyViewHolder(view)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: JellyViewHolder, position: Int) {
        val jellyBean = jellybeans[position]
        holder.flavorName.text = jellyBean.flavorName
        holder.description.text = jellyBean.description
        holder.backgroundColor.text = jellyBean.backgroundColor

    }


}