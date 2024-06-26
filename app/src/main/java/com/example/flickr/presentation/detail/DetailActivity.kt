package com.example.flickr.presentation.detail


import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.flickr.ImageUtils
import com.example.flickr.R
import com.example.flickr.domain.model.Image

class DetailActivity : AppCompatActivity() {
    private val viewModel: DetailViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val image = intent.getParcelableExtra<Image>(EXTRA_IMAGE)
        image?.let { viewModel.setImage(it) }
        viewModel.image.observe(this, Observer { image ->
            Glide.with(this)
                .load(ImageUtils.getImageUrl(image))
                .into(findViewById(R.id.imageView))
        })
    }
    companion object {
        const val EXTRA_IMAGE = "extra_image"
    }
}
