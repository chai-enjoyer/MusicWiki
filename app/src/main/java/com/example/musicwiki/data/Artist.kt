package com.example.musicwiki.data

data class Artist(
    val id: String,
    val name: String,
    val images: List<Image>,
    val genres: List<String>,
    val imageUrl: String
)

data class Image(
    val url: String
)