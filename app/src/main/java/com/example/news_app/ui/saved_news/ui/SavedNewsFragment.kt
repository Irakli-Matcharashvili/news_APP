package com.example.news_app.ui.saved_news.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.news_app.R
import com.example.news_app.ui.saved_news.vm.SavedNewsVm

class SavedNewsFragment : Fragment() {

    companion object {
        fun newInstance() = SavedNewsFragment()
    }

    private lateinit var viewModel: SavedNewsVm

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.saved_news_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SavedNewsVm::class.java)
        // TODO: Use the ViewModel
    }

}