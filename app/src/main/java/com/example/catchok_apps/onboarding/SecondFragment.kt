package com.example.catchok_apps.onboarding

import androidx.navigation.fragment.findNavController
import com.example.catchok_apps.R
import com.example.catchok_apps.BaseFragment
import com.example.catchok_apps.databinding.FragmentSecondBinding

class SecondFragment:BaseFragment<FragmentSecondBinding>(FragmentSecondBinding::inflate) {
    override var showBottomNavigation: Boolean = false
    override fun onBindView() {
        super.onBindView()
        binding.skipBtn.setOnClickListener {
            findNavController().navigate(
                R.id.action_viewPagerFragment_to_home
            )
        }
    }
}