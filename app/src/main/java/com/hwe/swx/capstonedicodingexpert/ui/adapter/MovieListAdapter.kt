package com.hwe.swx.capstonedicodingexpert.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hwe.swx.core.domain.model.Movie

class MovieListAdapter : RecyclerView.Adapter<MovieListViewHolder>() {

    private val movieList = ArrayList<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder =
        MovieListViewHolder.create(parent)


    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    override fun getItemCount(): Int = movieList.size

    fun setMovieList(movies: List<Movie>?) {
        if (movies == null) return
        movieList.clear()
        movieList.addAll(movies)
        notifyDataSetChanged()
    }

}