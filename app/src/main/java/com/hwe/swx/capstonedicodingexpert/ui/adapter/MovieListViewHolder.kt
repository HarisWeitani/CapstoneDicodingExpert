package com.hwe.swx.capstonedicodingexpert.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hwe.swx.capstonedicodingexpert.R
import com.hwe.swx.capstonedicodingexpert.databinding.MovieItemBinding
import com.hwe.swx.core.domain.model.Movie

class MovieListViewHolder(
    private val binding: MovieItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(data : Movie){

    }

    companion object{
        fun create(parent : ViewGroup) : MovieListViewHolder{
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.movie_item,parent,false)
            return MovieListViewHolder(MovieItemBinding.bind(view))
        }
    }
}