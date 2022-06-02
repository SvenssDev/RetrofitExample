package com.svenss.retrofitexample.util

import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.svenss.retrofitexample.R

/**
 * Created by miguelleon on 01,junio,2022
 */
fun ImageView.loadImage(url: String?){
    val progress = CircularProgressDrawable(this.context).apply {
        strokeWidth = 5f
        centerRadius = 30f
        start()
    }

    url?.let {
        Glide.with(this)
            .load(url)
            .placeholder(progress)
            .error(R.drawable.ic_launcher_background)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(this)
    }
}