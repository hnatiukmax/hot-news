package com.example.hotnews.presentation.boardnews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.transition.Slide
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.Observer
import com.example.hotnews.R
import com.example.hotnews.application.MyApplication
import com.example.hotnews.application.utils.off
import com.example.hotnews.application.utils.on
import com.example.hotnews.databinding.ActivityMainBinding
import com.example.hotnews.domain.News
import com.example.hotnews.presentation.adapters.SliderAdapter
import com.example.ratingmoviestask.ui.ContentPageAdapter
import com.google.android.material.navigation.NavigationView
import com.smarteist.autoimageslider.SliderPager
import com.smarteist.autoimageslider.SliderViewAdapter
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.toolbar.view.*
import javax.inject.Inject
import kotlin.system.exitProcess

class NewsActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View) {
        hideSearch()
        when (v.id) {
            R.id.imageView_search -> {
                showSearch()
            }
        }
    }

    fun showSearch() {
        binding.toolbar.apply {
            editText_search.on()
            imageView_search.off()
            textView_logo.off()
        }
    }

    fun hideSearch() {
        binding.toolbar.apply {
            editText_search.off()
            imageView_search.on()
            textView_logo.on()
        }
    }


    private val menuItemSelected = NavigationView.OnNavigationItemSelectedListener {
        when (it.itemId) {
            R.id.nav_exit -> {
                finish()
                exitProcess(0)
            }
        }
        return@OnNavigationItemSelectedListener true
    }

    @Inject
    lateinit var viewModel: NewsActivityViewModel

    private lateinit var binding: ActivityMainBinding
    private var pagerAdapter: ContentPageAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        MyApplication.getAppComponent().injectsNewsActivity(this)
        val toolBar = findViewById<Toolbar>(R.id.toolbar)

        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        val toggle = ActionBarDrawerToggle(
            this,
            drawer,
            toolBar,
            R.string.nav_open,
            R.string.nav_close
        )

        drawer.addDrawerListener(toggle)
        toggle.syncState()

        viewModel.newsList.observe(this, Observer {
            initPager(it)
        })

        binding.toolbar.editText_search.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.onSearch(s.toString())
            }

        })

        initUI()
    }

    private fun initUI() {
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        binding.tabLayout.tabLayout.apply {
            removeAllTabs()
            addTab(newTab().setText(resources.getString(R.string.tabStories)))
            addTab(newTab().setText(resources.getString(R.string.tabVideo)))
            addTab(newTab().setText(resources.getString(R.string.tabFavourites)))
        }
        binding.nv.setNavigationItemSelectedListener(menuItemSelected)
        binding.toolbar.imageView_search.setOnClickListener(this)
    }

    private fun initPager(list: List<News>) {
        val sliderAdapter = SliderAdapter(this, list.slice(0..3))
        pagerAdapter = ContentPageAdapter(supportFragmentManager, list)
        binding.apply {
            viewPager.adapter = pagerAdapter
            tabLayout.setupWithViewPager(viewPager)
            sliderView.sliderAdapter = sliderAdapter
        }
        pagerAdapter!!.updateFragments()
    }
}
