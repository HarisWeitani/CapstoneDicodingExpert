package com.hwe.swx.favorite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.hwe.swx.capstonedicodingexpert.ui.adapter.MovieListAdapter
import com.hwe.swx.capstonedicodingexpert.ui.detail.MovieDetailActivity
import com.hwe.swx.favorite.di.koin.favoriteModule
import kotlinx.android.synthetic.main.activity_favorite.*
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class FavoriteActivity : AppCompatActivity() {

    private val favoriteViewModel: FavoriteViewModel by viewModel()
    private lateinit var movieAdapter: MovieListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)

        loadKoinModules(favoriteModule)
        supportActionBar?.title = "Favorite"

        getMovieFavorite()
    }

    private fun getMovieFavorite() {
        favoriteViewModel.moviesFavorite.observe(this, Observer { movie ->
            if (movie != null) {
                movieAdapter = MovieListAdapter()

                with(rv_movie){
                    layoutManager = LinearLayoutManager(context)
                    adapter = movieAdapter
                }

                movieAdapter.onItemClick = {
                    val intent = Intent(this, MovieDetailActivity::class.java)
                    intent.putExtra(MovieDetailActivity.EXTRA_DATA, it)
                    startActivity(intent)
                }

                favoriteViewModel.moviesFavorite.observe(this, Observer {
                    movieAdapter.setMovieList(it)
                    tv_error_msg.visibility = if (it.isEmpty()) View.VISIBLE else View.GONE
                })

            }
        })
    }
}