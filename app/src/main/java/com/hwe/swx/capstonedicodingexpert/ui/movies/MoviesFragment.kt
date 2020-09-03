package com.hwe.swx.capstonedicodingexpert.ui.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.hwe.swx.capstonedicodingexpert.R
import com.hwe.swx.capstonedicodingexpert.databinding.FragmentMoviesBinding
import com.hwe.swx.capstonedicodingexpert.ui.adapter.MovieListAdapter
import com.hwe.swx.core.data.Resource
import org.koin.android.viewmodel.ext.android.viewModel

class MoviesFragment : Fragment() {

    private val moviesViewModel: MoviesViewModel by viewModel()
    private lateinit var binding: FragmentMoviesBinding
    private lateinit var movieAdapter: MovieListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMoviesBinding.inflate(inflater, container, false)
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

            moviesViewModel.moviesTopRated.observe(viewLifecycleOwner, Observer {
                if (it != null) {
                    when (it) {
                        is Resource.Loading -> {
                            binding.progressCircular.visibility = View.VISIBLE
                        }
                        is Resource.Error -> {
                            binding.progressCircular.visibility = View.GONE
                            binding.tvErrorMsg.visibility = View.VISIBLE
                            binding.tvErrorMsg.text = it.message?: getString(R.string.error_msg)
                        }
                        is Resource.Success -> {
                            binding.progressCircular.visibility = View.GONE
                            movieAdapter.setMovieList(it.data)
                        }
                    }
                }
            })
        }
    }
}