package com.example.catchok_apps.onboarding

import android.content.Context
import android.os.Handler
import androidx.navigation.fragment.findNavController
import com.example.catchok_apps.R
import com.example.catchok_apps.base.BaseFragment
import com.example.catchok_apps.databinding.FragmentSplashBinding

class SplashFragment:BaseFragment<FragmentSplashBinding>(FragmentSplashBinding::inflate) {
    override var showBottomNavigation: Boolean = false

    override fun onBindView() {
        super.onBindView()
        Handler().postDelayed({
            if(onBoardingFinished()){
                findNavController().navigate(R.id.action_splashFragment_to_home)
            }
            else {
                findNavController().navigate(R.id.action_splashFragment_to_viewPagerFragment)
            }
        }, 3000)
    }


    private fun onBoardingFinished():Boolean{
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        return sharedPref.getBoolean("Finished", false)
    }
}