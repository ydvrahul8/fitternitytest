package com.example.fitternitytest.view.fragment.splash

import androidx.navigation.findNavController
import com.example.fitternitytest.R
import com.example.fitternitytest.databinding.FragmentSplashBinding
import com.example.fitternitytest.model.Location
import com.example.fitternitytest.base.BaseFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashFragment : BaseFragment<FragmentSplashBinding>() {

    override val layout: Int
        get() = R.layout.fragment_splash

    private val activityScope = CoroutineScope(Dispatchers.Main)

    override fun init(bind: FragmentSplashBinding) {
        activityScope.launch {
            delay(1000)
            val location = Location.getData()[0]
            val action = SplashFragmentDirections.actionSplashFragmentToHomeFragment(location)
            view?.findNavController()?.navigate(action)
        }
    }
}