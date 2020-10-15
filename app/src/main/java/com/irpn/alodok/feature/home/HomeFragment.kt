package com.irpn.alodok.feature.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.irpn.alodok.R
import com.irpn.alodok.core.models.ItemContent
import com.irpn.alodok.feature.content.DetailContent
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Created by irpn on 14/10/20.
 * Email : padillahirpan8@gmail.com
 */

class HomeFragment : Fragment(), HomeAdapter.HomeAdapterListener  {

    private val homeAdapter by lazy {HomeAdapter(mutableListOf(), onClick = this)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupAdapter()
        setupData()
    }


    private fun setupAdapter() {
        with(rv_content) {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            adapter = homeAdapter

        }
    }

    private fun setupData() {

        //list image
        val listImage = mutableListOf<String>()
        listImage.add("https://static.toiimg.com/thumb/msid-67586673,width-800,height-600,resizemode-75,imgsize-3918697,pt-32,y_pad-40/67586673.jpg")
        listImage.add("https://api.time.com/wp-content/uploads/2015/02/cats.jpg?quality=85&w=1024&h=512&crop=1")
        listImage.add("https://cdn.mos.cms.futurecdn.net/VSy6kJDNq2pSXsCzb6cvYF.jpg")

        //list content
        val listItemContent = mutableListOf<ItemContent?>()
        listItemContent.add(ItemContent("1", "https://static.scientificamerican.com/sciam/cache/file/92E141F8-36E4-4331-BB2EE42AC8674DD3_source.jpg", "gambar1", listImage))
        listItemContent.add(ItemContent("2", "https://ichef.bbci.co.uk/news/976/cpsprodpb/12A9B/production/_111434467_gettyimages-1143489763.jpg", "gambar2", listImage))
        listItemContent.add(ItemContent("3", "https://www.vets4pets.com/siteassets/species/cat/close-up-of-cat-looking-up.jpg?w=585&scale=down", "gambar3", listImage))

        with(homeAdapter) {
            items = listItemContent
            notifyDataSetChanged()
        }
    }

    override fun onItemClicked(item: ItemContent) {
        DetailContent.startThisActivity(context, item)
    }
}