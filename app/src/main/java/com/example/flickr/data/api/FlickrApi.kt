package com.example.flickr.data.api

import com.example.flickr.presentation.search.SearchResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface FlickrApi {
    @GET("search")
    fun searchPhotos(@Query("text") query: String): Single<SearchResponse>
}