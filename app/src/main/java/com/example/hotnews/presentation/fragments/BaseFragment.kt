package com.example.hotnews.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.hotnews.R
import com.example.hotnews.domain.News


abstract class BaseFragment(
    protected val movies: List<News>

) : Fragment() {

    protected var recycler: RecyclerView? = null

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val rootView = inflater.inflate(R.layout.fragment_content, container, false)

        recycler = rootView.findViewById(R.id.recyclerView_data)
        initRecycler()

        return rootView
    }

    abstract fun initRecycler()
    abstract fun setMoviesList(movies : List<News>)
    abstract fun updateList()
}
