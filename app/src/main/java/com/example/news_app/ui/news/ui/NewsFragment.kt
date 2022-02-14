package com.example.news_app.ui.news.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.news_app.ui.adapter.OnItemClickListener
import com.example.news_app.databinding.NewsFragmentBinding
import com.example.news_app.model.Articles
import com.example.news_app.ui.adapter.NewsAdapter
import com.example.news_app.ui.base.BaseFragment
import com.example.news_app.ui.news.vm.NewsVm

class NewsFragment : BaseFragment<NewsFragmentBinding, NewsVm>(), OnItemClickListener {
    override val bindingInflater: (inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean) -> NewsFragmentBinding
        get() = NewsFragmentBinding::inflate

    override fun getViewModelClass(): Class<NewsVm> = NewsVm::class.java
    private val newsAdapter by lazy { NewsAdapter(this) }

    override fun init() {
        newsViewModel.getCustomCategoryNews(category = "business")
        SetUpNewsreciclerView()
        observeSuccessLiveData()
        observeErrorLiveData()

    }

    private fun SetUpNewsreciclerView() {
        with(binding.newsRecyclerView) {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = newsAdapter
        }
    }


    private fun observeErrorLiveData() {
        newsViewModel.errorLiveData.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }
    }

    private fun observeSuccessLiveData() {
        newsViewModel.successNewsLiveData.observe(viewLifecycleOwner) {
            newsAdapter.submitList(it.articles)
        }
    }


    override fun onItemClick(article: Articles) {
    }

    private fun setListener() {

    }
}


