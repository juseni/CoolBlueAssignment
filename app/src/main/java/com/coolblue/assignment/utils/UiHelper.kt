package com.coolblue.assignment.utils

import android.content.Context
import android.widget.ImageView
import com.coolblue.assignment.R

/**
 * @author Juan Sebastian Niño
 */
fun loadImageFromUrl(
    context: Context,
    imageView: ImageView,
    url: String?
) {
   if (url == null) {
       imageView.setImageResource(R.color.teal_700)
   } else {
        GlideApp.with(context)
            .load(url)
            .placeholder(R.color.teal_700)
            .error(R.color.teal_700)
            .into(imageView)
   }
}