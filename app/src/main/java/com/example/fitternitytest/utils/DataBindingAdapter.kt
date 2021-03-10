package com.example.fitternitytest.utils

import android.graphics.Color
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.fitternitytest.R

@BindingAdapter("imageResource")
fun setImageResource(view: ImageView, imageUrl: String?) {
    val context = view.context
    val option: RequestOptions = RequestOptions()
        .placeholder(R.drawable.ic_launcher_background)
        .error(R.drawable.ic_launcher_background)
    Glide.with(context)
        .setDefaultRequestOptions(option)
        .load(imageUrl)
        .into(view)
}


@BindingAdapter("customColor")
fun setTextColor(view: TextView, color: String?) {
    if (color != null)
        view.setTextColor(Color.parseColor(color))
}
