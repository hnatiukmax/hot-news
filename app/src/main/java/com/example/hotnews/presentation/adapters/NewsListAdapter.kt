package com.example.ratingmoviestask.ui

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hotnews.R
import com.example.hotnews.application.utils.blink
import com.example.hotnews.domain.News


class NewsListAdapter : RecyclerView.Adapter<NewsListAdapter.NewsListHolder> {

    private var context : Context
    var news : List<News>

    constructor(context : Context, movies : List<News>) : super() {
        this.context = context
        this.news = movies
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): NewsListHolder {
        var itemView = LayoutInflater.from(p0.context).inflate(R.layout.layout_item_news, p0, false)
        return NewsListHolder(itemView)
    }

    override fun getItemCount(): Int {
        return news.size
    }

    override fun onBindViewHolder(item: NewsListHolder, index: Int) {
        val news = news[index]

        item.description.text = news.description
        item.date.text = " - ${news.date} hours ago"
        item.resource.text = news.id.toString()

        Glide
            .with(context)
            .load(news.poster.url)
            .into(item.poster)
    }

    class NewsListHolder : RecyclerView.ViewHolder {

        var poster : ImageView
        var description : TextView
        var date: TextView
        var resource : TextView

        constructor(view : View) : super(view) {
            poster = view.findViewById(R.id.imageView_poster)
            description = view.findViewById(R.id.textView_description)
            date = view.findViewById(R.id.textView_date)
            resource= view.findViewById(R.id.textView_resource)
        }
    }
}
