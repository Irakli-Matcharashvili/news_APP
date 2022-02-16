package com.example.news_app.ui.splash_screen.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.news_app.R
import com.example.news_app.databinding.SplashScreenFragmentBinding
import com.example.news_app.ui.base.BaseFragment
import com.example.news_app.ui.splash_screen.vm.SplashScreenVm
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CustomSplashScreen")
class SplashScreenFragment : BaseFragment<SplashScreenFragmentBinding, SplashScreenVm>() {

    override val bindingInflater: (inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean) -> SplashScreenFragmentBinding
        get() = SplashScreenFragmentBinding::inflate

    override fun getViewModelClass(): Class<SplashScreenVm> = SplashScreenVm::class.java

    override fun init() {
        newsVm.getValue()
        makeAnimation()
        observeSplashScreenLiveData()
    }

    private fun observeSplashScreenLiveData() {
        newsVm.splashScreenLiveData.observe(viewLifecycleOwner) {
            determineNavigation(if (it.toBoolean()) NAVIGATE_NEWS else NAVIGATE_ON_BOARDING)
        }
    }

    private fun makeAnimation() {
        with(binding.splashScreenLogo.animate()) {
            duration = ANIMATION_DURATION
            rotation(LOGO_ROTATION)
        }
    }

    private fun determineNavigation(destination: Int) {
        lifecycleScope.launch {
            delay(DELAY)
            findNavController().navigate(destination)
        }
    }

    companion object {
        private const val NAVIGATE_ON_BOARDING = R.id.action_splashScreenFragment_to_onBoardingFragment
        private const val NAVIGATE_NEWS = R.id.action_splashScreenFragment_to_newsFragment
        private const val DELAY = 3000L
        private const val ANIMATION_DURATION = 2500L
        private const val LOGO_ROTATION = 360f
    }
}