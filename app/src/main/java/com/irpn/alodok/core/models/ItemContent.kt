package com.irpn.alodok.core.models

import java.io.Serializable


/**
 * Created by irpn on 14/10/20.
 * Email : padillahirpan8@gmail.com
 */

data class ItemContent(val idImage: String, val imageUrl: String, val name: String, val listImage: MutableList<String>): Serializable