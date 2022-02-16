package com.example.news_app.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.news_app.databinding.NewsRowLayoutBinding
import com.example.news_app.model.Articles
import com.example.news_app.util.ItemsDiffUtil

class NewsAdapter(private val onItemClickListener: OnItemClickListener) :
    ListAdapter<Articles, NewsAdapter.ViewHolder>(ItemsDiffUtil<Articles>()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            NewsRowLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position), onItemClickListener)
    }

    class ViewHolder(private val binding: NewsRowLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(articles: Articles, onItemClickListener: OnItemClickListener) {
            with(binding) {
                newsTitleTextView.text = articles.title
                newsSubjectTextView.text = articles.source.name
                newsDateTextView.text = articles.publishedAt
                Glide.with (newsImageView.context).load(articles.urlToImage).into(newsImageView)
                newsRowLayout.setOnClickListener {
                    onItemClickListener.onItemClick(articles)
                }
            }
        }
    }
}