package com.irpn.alodok.feature.content

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.irpn.alodok.R
import com.irpn.alodok.core.models.ItemContent
import kotlinx.android.synthetic.main.activity_detail_content.*

/**
 * Created by irpn on 14/10/20.
 * Email : padillahirpan8@gmail.com
 */

class DetailContent : AppCompatActivity() {

    companion object {
        const val EXTRA_STRING = "product"
        fun startThisActivity(context: Context?, item: ItemContent?) {
            val intent = Intent(context, DetailContent::class.java)
            intent.putExtra(EXTRA_STRING, item)
            context?.startActivity(intent)
        }
    }

    var item: ItemContent? = null

    private val imageList = ArrayList<SlideModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_content)


        setData()
    }

    private fun setData() {

        item = intent.getSerializableExtra(EXTRA_STRING) as ItemContent
        item?.let {
            for (image in it.listImage) {
                imageList.add(SlideModel(image))
            }
        }

        imageSlider.setImageList(imageList, ScaleTypes.CENTER_CROP)
    }
}