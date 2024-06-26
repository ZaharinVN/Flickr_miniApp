package com.example.flickr.presentation.search

import android.media.Image
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.flickr.domain.usecase.GetSuggestionsUseCase
import com.example.flickr.domain.usecase.SearchUseCase


class SearchViewModel(
    private val searchUseCase: SearchUseCase,
    private val getSuggestionsUseCase: GetSuggestionsUseCase
) : ViewModel() {

    private val _images = MutableLiveData<List<Image>>()
    val images: LiveData<List<Image>> = _images

    private val _suggestions = MutableLiveData<List<String>>()
    val suggestions: LiveData<List<String>> = _suggestions

    fun search(query: String?) {
        searchUseCase.execute(query)
            .subscribe(
                { _images.value = it },
                { /* Handle error */ }
            )
    }

    fun getSuggestions(query: String?) {
        getSuggestionsUseCase.execute(query)
            .subscribe(
                { _suggestions.value = it },
                { /* Handle error */ }
            )
    }
}