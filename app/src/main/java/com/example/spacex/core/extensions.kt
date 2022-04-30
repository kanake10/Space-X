package com.example.spacex.core

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load


    @BindingAdapter("imageUrl")
    fun setImageUrl(imageView: ImageView, url: String?) {
        imageView.load(url) { crossfade(true) }
    }

