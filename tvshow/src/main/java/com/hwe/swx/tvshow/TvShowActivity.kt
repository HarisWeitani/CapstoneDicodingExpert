package com.hwe.swx.tvshow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hwe.swx.capstonedicodingexpert.ui.adapter.MovieListAdapter
import com.hwe.swx.tvshow.di.koin.tvshowModule
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class TvShowActivity : AppCompatActivity() {

    private val tvShowViewModel: TvShowViewModel by viewModel()
    private lateinit var movieAdapter: MovieListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tv_show)

        loadKoinModules(tvshowModule)

        supportActionBar?.title = "TV Show"

        getTvShow()
    }

    private fun getTvShow() {

    }
}