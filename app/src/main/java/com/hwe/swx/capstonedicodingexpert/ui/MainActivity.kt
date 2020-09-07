package com.hwe.swx.capstonedicodingexpert.ui

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.hwe.swx.capstonedicodingexpert.R
import com.hwe.swx.capstonedicodingexpert.databinding.ActivityMainBinding
import com.hwe.swx.capstonedicodingexpert.ui.adapter.MovieListAdapter
import com.hwe.swx.capstonedicodingexpert.ui.detail.MovieDetailActivity
import com.hwe.swx.core.data.Resource
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainViewModel : MainViewModel by viewModel()
    private lateinit var binding : ActivityMainBinding
    private lateinit var movieAdapter : MovieListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initAdapter()
    }

    private fun initAdapter(){
        movieAdapter = MovieListAdapter()

        with(binding.rvMovie) {
            layoutManager = LinearLayoutManager(context)
            adapter = movieAdapter
        }

        movieAdapter.onItemClick = {
            val intent = Intent(this@MainActivity, MovieDetailActivity::class.java)
            intent.putExtra(MovieDetailActivity.EXTRA_DATA, it)
            startActivity(intent)
        }

        mainViewModel.moviesTopRated.observe(this, Observer {
            if (it != null) {
                when (it) {
                    is Resource.Loading -> {
                        binding.progressCircular.visibility = View.VISIBLE
                    }
                    is Resource.Error -> {
                        binding.progressCircular.visibility = View.GONE
                        binding.tvErrorMsg.visibility = View.VISIBLE
                        binding.tvErrorMsg.text = it.message ?: getString(R.string.error_msg)
                    }
                    is Resource.Success -> {
                        binding.progressCircular.visibility = View.GONE
                        movieAdapter.setMovieList(it.data)
                    }
                }
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.item_favorite->{
                val uri = Uri.parse("movieapp://favorite")
                startActivity(Intent(Intent.ACTION_VIEW, uri))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}