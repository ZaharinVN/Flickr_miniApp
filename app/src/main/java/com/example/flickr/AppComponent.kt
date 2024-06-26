package com.example.flickr

import com.example.flickr.domain.usecase.UseCaseModule
import com.example.flickr.presentation.detail.DetailActivity
import com.example.flickr.presentation.search.SearchActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        ApiModule::class,
        RepositoryModule::class,
        UseCaseModule::class
    ]
)
interface AppComponent {
    fun inject(searchActivity: SearchActivity)
    fun inject(detailActivity: DetailActivity)
}