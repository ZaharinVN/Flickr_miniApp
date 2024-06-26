package com.example.flickr.presentation.search


import android.media.Image
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.flickr.FlickrPhoto
import com.example.flickr.ImageUtils

class SearchAdapter : BaseAdapter() {
    private val images = mutableListOf<FlickrPhoto>()
    override fun getItem(position: Int) = images[position] as Image
    override fun getCount() = images.size
    override fun getItemId(position: Int) = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val imageView = convertView as? ImageView ?: ImageView(parent?.context)
        Glide.with(imageView)
            .load(ImageUtils.getImageUrl(images[position]))
            .into(imageView)
        return imageView
    }

    fun updateData(newImages: List<Image>) {
        images.clear()
        images.addAll(newImages)
        notifyDataSetChanged()
    }
}