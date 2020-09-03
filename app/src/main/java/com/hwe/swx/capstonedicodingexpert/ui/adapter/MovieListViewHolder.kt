package com.hwe.swx.capstonedicodingexpert.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.hwe.swx.capstonedicodingexpert.BuildConfig
import com.hwe.swx.capstonedicodingexpert.R
import com.hwe.swx.capstonedicodingexpert.databinding.MovieItemBinding
import com.hwe.swx.core.domain.model.Movie
import com.squareup.picasso.Picasso

class MovieListViewHolder(
    private val binding: MovieItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(data: Movie) {

        Picasso.get()
            .load(BuildConfig.POSTER_BASE_URL + data.poster_path)
            .placeholder(R.drawable.ic_baseline_image_24)
            .error(R.drawable.ic_baseline_broken_image_24)
            .into(binding.ivPoster)

        binding.tvTitle.text = data.title
        binding.tvReleaseDate.text = data.release_date
        binding.tvVoteAverage.text = data.vote_average.toString()
        binding.ivFavorite.visibility = if (data.is_favorite) View.VISIBLE else View.GONE

        itemView.setOnClickListener {
            Log.d("asoy", "bind: ${data.title}")
        }
    }

    companion object {
        fun create(parent: ViewGroup): MovieListViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.movie_item, parent, false)
            return MovieListViewHolder(MovieItemBinding.bind(view))
        }
    }
}