package com.example.news_app.ui.news.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.news_app.R
import com.example.news_app.databinding.CategoryItemLayoutBinding
import com.example.news_app.ui.news.adapter.model.Category
import com.example.news_app.util.ItemsDiffUtil

class CategoryAdapter (private val onCategoryItemListener: OnCategoryItemListener) :
ListAdapter<Category, CategoryAdapter.ViewHolder>(ItemsDiffUtil<Category>()) {

    private var selectedPosition = SELECTED_POSITION

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            CategoryItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position))
        with(holder.binding) {
            categoryTextView.setOnClickListener {
                selectedPosition = holder.adapterPosition
                onCategoryItemListener.onCategoryItemClick(getItem(position).category)
                notifyDataSetChanged()
                if (holder.adapterPosition == selectedPosition) {
                    categoryTextView.setTextColor(Color.parseColor(R.color.app_items_dark.toString()))
                    categoryTextView.paint.isUnderlineText = true
                } else {
                    categoryTextView.setTextColor(Color.parseColor(R.color.api_category_color.toString()))
                    categoryTextView.paint.isUnderlineText = false
                }
            }
        }
    }

    class ViewHolder(val binding: CategoryItemLayoutBinding):
        RecyclerView.ViewHolder(binding.root) {

            fun onBind(category: Category) {
                with(binding) {
                    categoryTextView.text = category.category
                }
            }
    }

    companion object {
       const val SELECTED_POSITION = 0
    }
}