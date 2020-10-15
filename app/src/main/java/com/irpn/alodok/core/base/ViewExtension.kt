package com.irpn.alodok.core.base

import android.widget.ImageView
import com.bumptech.glide.Glide


/**
 * Created by irpn on 14/10/20.
 * Email : padillahirpan8@gmail.com
 */

fun ImageView.loadCornerImage(uri: String?, icPlaceholder: Int? = 0, radius: Int, margin: Int? = 0) =
    Glide.with(this.context.applicationContext)
        .load(uri)
        .placeholder(icPlaceholder!!)
        .into(this)