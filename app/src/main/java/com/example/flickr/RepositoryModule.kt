package com.example.flickr

import com.example.flickr.data.api.FlickrApi
import com.example.flickr.data.repository.SearchRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun provideSearchRepository(flickrApi: FlickrApi): SearchRepository {
        return SearchRepository(flickrApi)
    }
}