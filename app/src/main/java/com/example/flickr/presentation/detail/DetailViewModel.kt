package com.example.flickr.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.flickr.domain.model.Image

class DetailViewModel(
    private val _image: MutableLiveData<Image> = MutableLiveData()
) : ViewModel() {
    val image: LiveData<Image> = _image
    fun setImage(image: Image) {
        _image.value = image
    }
}