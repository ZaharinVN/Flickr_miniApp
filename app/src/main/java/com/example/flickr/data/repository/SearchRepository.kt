package com.example.flickr.data.repository

import com.example.flickr.data.api.FlickrApi
import com.example.flickr.domain.model.Image
import io.reactivex.rxjava3.core.Single

class SearchRepository(
    private val flickrApi: FlickrApi
) {
    fun searchPhotos(query: String): Single<List<Image>> {
        return flickrApi.searchPhotos(query)
            .map { it.photos.photo.map { photo -> Image(photo.url) } }
    }

    fun getSuggestions(query: String): Single<List<String>> {
        // Implement logic to retrieve previous search queries
        return Single.just(listOf("previous search 1", "previous search 2"))
    }
}

