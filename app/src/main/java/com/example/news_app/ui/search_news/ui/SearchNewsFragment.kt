package com.example.news_app.ui.search_news.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.news_app.R
import com.example.news_app.ui.search_news.vm.SearchNewsVm

class SearchNewsFragment : Fragment() {

    companion object {
        fun newInstance() = SearchNewsFragment()
    }

    private lateinit var viewModel: SearchNewsVm

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.search_news_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SearchNewsVm::class.java)
        // TODO: Use the ViewModel
    }

}