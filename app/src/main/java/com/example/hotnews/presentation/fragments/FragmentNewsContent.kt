package com.example.hotnews.presentation.fragments

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hotnews.domain.News
import com.example.ratingmoviestask.ui.NewsListAdapter

class FragmentNewsContent(movies : List<News>) : BaseFragment(movies) {

    private var adapter : NewsListAdapter? = null

    override fun initRecycler() {
        adapter = NewsListAdapter(context!!, movies)
        recycler?.adapter = adapter
        recycler?.layoutManager = LinearLayoutManager(context!!)
        updateList()
    }

    override fun setMoviesList(movies : List<News>) {
        adapter?.news = movies
        updateList()
    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

}