package com.example.catchok_apps.onboarding

import android.content.Context
import androidx.navigation.fragment.findNavController
import com.example.catchok_apps.R
import com.example.catchok_apps.base.BaseFragment
import com.example.catchok_apps.databinding.FragmentThirdBinding

class ThirdFragment:BaseFragment<FragmentThirdBinding>(FragmentThirdBinding::inflate) {
    override var showBottomNavigation: Boolean = false


    override fun onBindView() {
        super.onBindView()
        binding.finish.setOnClickListener{
            findNavController().navigate(R.id.action_viewPagerFragment_to_home)
            onBoardingFinished()
        }
    }


    private fun onBoardingFinished(){
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean("Finished", true)
        editor.apply()
    }
}