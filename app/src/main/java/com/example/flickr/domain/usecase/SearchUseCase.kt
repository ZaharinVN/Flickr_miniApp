package com.example.flickr.domain.usecase

import com.example.flickr.data.repository.SearchRepository
import io.reactivex.rxjava3.core.Single

class SearchUseCase(
    private val searchRepository: SearchRepository
) {
    fun execute(query: String?): Single<List<com.example.flickr.domain.model.Image>> {
        return searchRepository.searchPhotos(query ?: "")
    }
}