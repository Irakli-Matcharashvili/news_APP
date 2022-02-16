package com.example.news_app.ui.news.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.news_app.ui.adapter.OnItemClickListener
import com.example.news_app.databinding.NewsFragmentBinding
import com.example.news_app.model.Articles
import com.example.news_app.ui.adapter.NewsAdapter
import com.example.news_app.ui.base.BaseFragment
import com.example.news_app.ui.news.adapter.CategoryAdapter
import com.example.news_app.ui.news.adapter.model.Category
import com.example.news_app.ui.news.vm.NewsVm
import com.example.news_app.util.exlensions.showToast

class NewsFragment : BaseFragment<NewsFragmentBinding, NewsVm>(), OnItemClickListener {
    override val bindingInflater: (inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean) -> NewsFragmentBinding
        get() = NewsFragmentBinding::inflate

    override fun getViewModelClass(): Class<NewsVm> = NewsVm::class.java

    private val newsAdapter by lazy { NewsAdapter(this) }

    private val categoryAdapter by lazy { CategoryAdapter(this) }

    override fun init() {
        newsVm.getCustomCategoryNews(DEFAULT_CATEGORY)
        isShownProgressBar(true)
        setUpNewsRecyclerView()
        observeSuccessLiveData()
        observeErrorLiveData()
        setUpCategoriesRecyclerView()
        categoryAdapter.submitList(CATEGORIES)
    }

    private fun observeSuccessLiveData() {
        newsVm.successNewsLiveData.observe(viewLifecycleOwner) {
            isShownProgressBar(false)
            newsAdapter.submitList(it.articles)
        }
    }

    private fun observeErrorLiveData() {
        newsVm.errorLiveData.observe(viewLifecycleOwner) {
            isShownProgressBar(false)
            it.showToast(requireContext())
        }
    }

    private fun setUpNewsRecyclerView() {
        with(binding.newsRecyclerView) {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = newsAdapter
        }
    }

    private fun setUpCategoriesRecyclerView() {
        with(binding.newsRecyclerView) {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = categoryAdapter
        }
    }

    private fun isShownProgressBar(progressBar: Boolean) {
        binding.customProgressBar.isVisible = progressBar
    }

    override fun onItemClick(article: Articles) {
        findNavController().navigate(
            NewsFragmentDirection.actionNewsFragmentToNewsDetailFragment(article)
        )
    }

    override fun onCategoryItemClick (category: String) {
        isShownProgressBar(true)
        newsVm.getCustomCategoryNews(category)
    }

    companion object {
        private const val DEFAULT_CATEGORY = "business"
        private val CATEGORIES = listOf(
            Category("business"),
            Category("sports"),
            Category("technology"),
            Category("science")
        )
    }
}