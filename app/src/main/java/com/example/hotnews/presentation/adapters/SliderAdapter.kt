package com.example.hotnews.presentation.adapters

import android.content.Context
import android.widget.TextView
import com.smarteist.autoimageslider.SliderViewAdapter
import com.bumptech.glide.Glide
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.hotnews.R
import com.example.hotnews.domain.News


class SliderAdapter(private val context : Context, private val list : List<News>) :
    SliderViewAdapter<SliderAdapter.SliderAdapterVH>() {



    override fun onCreateViewHolder(parent: ViewGroup): SliderAdapterVH {
        val inflate =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_item_news_slider, null)
        return SliderAdapterVH(inflate)
    }

    override fun onBindViewHolder(viewHolder: SliderAdapterVH, position: Int) {
        val item = list[position]

        viewHolder.description.text = item.description

        Glide
            .with(context)
            .load(item.poster.url)
            .into(viewHolder.poster)
    }

    override fun getCount(): Int {
        //slider view count could be dynamic size
        return 4
    }

    inner class SliderAdapterVH(var itemView: View) :
        SliderViewAdapter.ViewHolder(itemView) {
        val poster : ImageView = itemView.findViewById(R.id.imageView_poster)
        val description : TextView = itemView.findViewById(R.id.textView_description)


    }
}