package com.example.news_app.ui.onboarding.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.news_app.R
import com.example.news_app.ui.onboarding.vm.OnBoardingVm

class OnBoardingFragment : Fragment() {

    companion object {
        fun newInstance() = OnBoardingFragment()
    }

    private lateinit var viewModel: OnBoardingVm

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.onboarding_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(OnBoardingVm::class.java)
        // TODO: Use the ViewModel
    }

}