package com.example.dolgozat.model

data class JellyResponse(
    val items: List<JellyBean>
)

data class JellyBean(
    val flavorName: String,
    val description: String,
    val backgroundColor: String
)