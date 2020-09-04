package com.hwe.swx.capstonedicodingexpert.ui.favorite

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.hwe.swx.capstonedicodingexpert.R
import com.hwe.swx.capstonedicodingexpert.databinding.FragmentFavoriteBinding
import com.hwe.swx.capstonedicodingexpert.ui.adapter.MovieListAdapter
import com.hwe.swx.capstonedicodingexpert.ui.detail.MovieDetailActivity
import org.koin.android.viewmodel.ext.android.viewModel

class FavoriteFragment : Fragment() {

    private val favoriteViewModel: FavoriteViewModel by viewModel()
    private lateinit var binding: FragmentFavoriteBinding
    private lateinit var movieAdapter: MovieListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            movieAdapter = MovieListAdapter()

            with(binding.rvMovie) {
                layoutManager = LinearLayoutManager(context)
                adapter = movieAdapter
            }

            movieAdapter.onItemClick = {
                val intent = Intent(activity, MovieDetailActivity::class.java)
                intent.putExtra(MovieDetailActivity.EXTRA_DATA, it)
                startActivity(intent)
            }

            favoriteViewModel.moviesFavorite.observe(viewLifecycleOwner, Observer {
                movieAdapter.setMovieList(it)
                binding.tvErrorMsg.visibility = if (it.isEmpty()) View.VISIBLE else View.GONE
            })
        }
    }
}