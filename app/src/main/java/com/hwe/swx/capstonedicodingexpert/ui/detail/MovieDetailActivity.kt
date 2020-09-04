package com.hwe.swx.capstonedicodingexpert.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.hwe.swx.capstonedicodingexpert.BuildConfig
import com.hwe.swx.capstonedicodingexpert.R
import com.hwe.swx.capstonedicodingexpert.databinding.ActivityMovieDetailBinding
import com.hwe.swx.core.domain.model.Movie
import com.squareup.picasso.Picasso
import org.koin.android.viewmodel.ext.android.viewModel

class MovieDetailActivity : AppCompatActivity() {

    private val movieDetailViewModel: MovieDetailViewModel by viewModel()
    private lateinit var binding: ActivityMovieDetailBinding

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val movieDetail = intent.getParcelableExtra<Movie>(EXTRA_DATA)
        showMovieDetail(movieDetail)
    }

    private fun showMovieDetail(movie: Movie?) {
        movie?.let {
            Picasso.get()
                .load(BuildConfig.POSTER_BASE_URL + movie.poster_path)
                .placeholder(R.drawable.ic_baseline_image_24)
                .error(R.drawable.ic_baseline_broken_image_24)
                .into(binding.ivPoster)

            binding.tvPopularity.text = movie.popularity.toString()
            binding.tvVoteAverage.text = movie.vote_average.toString()
            binding.tvVoteCount.text = movie.vote_count.toString()
            binding.ivFavorite.setImageDrawable(
                if (movie.is_favorite)
                    ContextCompat.getDrawable(this, R.drawable.ic_baseline_favorite_24)
                else
                    ContextCompat.getDrawable(this, R.drawable.ic_baseline_favorite_border_24)
            )

            binding.tvTitle.text = movie.title
            binding.tvReleaseDate.text = movie.release_date
            binding.tvOverview.text = movie.overview

            binding.ivFavorite.setOnClickListener {
                setStatusFavorite(!movie.is_favorite)
                movieDetailViewModel.setFavoriteMovie(movie, !movie.is_favorite)
            }
        }
    }

    private fun setStatusFavorite(isFavorite: Boolean) {
        binding.ivFavorite.setImageDrawable(
            if (isFavorite) {
                ContextCompat.getDrawable(this, R.drawable.ic_baseline_favorite_24)
            } else {
                ContextCompat.getDrawable(this, R.drawable.ic_baseline_favorite_border_24)
            }
        )
    }


}