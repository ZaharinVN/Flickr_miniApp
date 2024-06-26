package com.example.flickr

object ImageUtils {
    fun getImageUrl(photo: FlickrPhoto): String {
        return "https://live.staticflickr.com/${photo.server}/${photo.id}_${photo.secret}.jpg"
    }
}