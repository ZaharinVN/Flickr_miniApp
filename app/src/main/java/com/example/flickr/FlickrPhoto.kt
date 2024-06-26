package com.example.flickr

data class FlickrPhoto(
    val id: String,
    val url: String,
    val owner: String,
    val secret: String,
    val server: String,
    val title: String
)