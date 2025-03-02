package com.example.kotlinbasics.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlinbasics.R
import com.example.kotlinbasics.model.Color

class ColorAdapter(private val colorList: List<Color>) :
    RecyclerView.Adapter<ColorAdapter.ColorViewHolder>() {

    class ColorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val colorName: TextView = itemView.findViewById(R.id.colorName)
        val colorView: ImageView = itemView.findViewById(R.id.colorImageView)
        val colorYear: TextView = itemView.findViewById(R.id.colorYear)
        val colorPantone: TextView = itemView.findViewById(R.id.colorPantone)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_color, parent, false)
        return ColorViewHolder(view)
    }

    override fun onBindViewHolder(holder: ColorViewHolder, position: Int) {
        val colors = colorList[position]

        holder.colorName.text = colors.name
        holder.colorView.setBackgroundColor(android.graphics.Color.parseColor(colors.color))
        holder.colorYear.text = colors.year.toString()
        holder.colorPantone.text = colors.pantone_value
        holder.colorView.background.setTint(android.graphics.Color.parseColor(colors.color))

    }

    override fun getItemCount(): Int {
        return colorList.size
    }
}