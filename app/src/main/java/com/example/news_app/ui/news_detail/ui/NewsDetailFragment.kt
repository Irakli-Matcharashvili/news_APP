package com.example.news_app.ui.news_detail.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.news_app.R
import com.example.news_app.ui.news_detail.vm.NewsDetailVm

class NewsDetailFragment : Fragment() {

    companion object {
        fun newInstance() = NewsDetailFragment()
    }

    private lateinit var viewModel: NewsDetailVm

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.news_detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(NewsDetailVm::class.java)
        // TODO: Use the ViewModel
    }

}