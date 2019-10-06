package com.example.ratingmoviestask.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.hotnews.domain.News
import com.example.hotnews.presentation.fragments.FragmentNewsContent

@Suppress("DEPRECATION")
class ContentPageAdapter(fm: FragmentManager, var news: List<News>) : FragmentPagerAdapter(fm) {

    private val titles : Array<String> = arrayOf("STORIES", "VIDEO", "FAVOURITES")
    private val fragments= arrayOf(
        FragmentNewsContent(news),
        FragmentNewsContent(news),
        FragmentNewsContent(news)
        )

    override fun getItem(position: Int): Fragment = fragments[position]

    override fun getCount(): Int = 3

    override fun getPageTitle(position: Int): CharSequence? = titles[position]

    fun setFragmentsMovies(movies : List<News>) {
        fragments.forEach {
            it.setMoviesList(movies)
        }
    }

    fun updateFragments() {
       fragments.forEach {
           it.updateList()
       }
    }
}