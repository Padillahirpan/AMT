package com.irpn.alodok.feature.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.irpn.alodok.R
import com.irpn.alodok.core.base.loadCornerImage
import com.irpn.alodok.core.models.ItemContent
import kotlinx.android.synthetic.main.item_content.view.*

/**
 * Created by irpn on 14/10/20.
 * Email : padillahirpan8@gmail.com
 */

class HomeAdapter(
    var items: MutableList<ItemContent?>,
    val onClick: HomeAdapterListener): RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_content, parent, false), onClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        items[position]?.let {
            holder.bind(it)
        }
    }

    class ViewHolder(itemView: View, var onClick: HomeAdapterListener) : RecyclerView.ViewHolder(itemView) {

        fun bind(
            data: ItemContent?
        ) {
            with(itemView) {
                iv_content.loadCornerImage(data?.imageUrl,radius = 0)
                setOnClickListener { data?.let { onClick.onItemClicked(it) }}
            }
        }

    }

    interface HomeAdapterListener {
        fun onItemClicked(item: ItemContent)
    }

    override fun getItemCount() = items.size
}