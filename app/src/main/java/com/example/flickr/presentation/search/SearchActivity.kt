package com.example.flickr.presentation.search

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.GridView
import android.widget.SearchView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.flickr.R
import com.example.flickr.domain.model.Image
import com.example.flickr.presentation.detail.DetailActivity

class SearchActivity : AppCompatActivity() {
    private val viewModel: SearchViewModel by viewModels()
    private val searchAdapter: SearchAdapter by lazy { SearchAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        // Найдите и используйте searchView и gridView
        val searchView = findViewById<SearchView>(R.id.searchView)
        val gridView = findViewById<GridView>(R.id.gridView)

        // Настройка поисковой строки
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                viewModel.search(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                viewModel.getSuggestions(newText)
                return true
            }
        })

        // Настройка grid-view
        gridView.adapter = searchAdapter
        gridView.setOnItemClickListener { _, _, position, _ ->
            val image = searchAdapter.getItem(position) as Image
            startActivity(Intent(this, DetailActivity::class.java)
                .putExtra(DetailActivity.EXTRA_IMAGE, image))
        }

        // Наблюдение за ViewModel
        viewModel.images.observe(this, Observer { images ->
            searchAdapter.updateData(images)
        })
        viewModel.suggestions.observe(this, Observer { suggestions ->
            (searchView.suggestionsAdapter as? ArrayAdapter<String>)?.
            addAll(suggestions)
        })
    }
}

