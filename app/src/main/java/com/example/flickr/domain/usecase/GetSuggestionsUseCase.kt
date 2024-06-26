package com.example.flickr.domain.usecase

import com.example.flickr.data.repository.SearchRepository
import io.reactivex.rxjava3.core.Single

class GetSuggestionsUseCase(
    private val searchRepository: SearchRepository
) {
    fun execute(query: String?): Single<List<String>> {
        return searchRepository.getSuggestions(query ?: "")
    }
}