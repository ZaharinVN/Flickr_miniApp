package com.example.flickr.domain.usecase

import com.example.flickr.data.api.SearchRepository
import com.example.flickr.domain.model.GetSuggestionsUseCase
import com.example.flickr.domain.model.SearchUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {
    @Provides
    @Singleton
    fun provideSearchUseCase(searchRepository: SearchRepository): SearchUseCase {
        return SearchUseCase(searchRepository)
    }

    @Provides
    @Singleton
    fun provideGetSuggestionsUseCase(searchRepository: SearchRepository): GetSuggestionsUseCase {
        return GetSuggestionsUseCase(searchRepository)
    }
}