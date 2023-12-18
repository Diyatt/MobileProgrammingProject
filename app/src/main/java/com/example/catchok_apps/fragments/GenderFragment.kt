package com.example.catchok_apps.fragments

import android.annotation.SuppressLint
import androidx.navigation.fragment.findNavController
import com.example.catchok_apps.R
import com.example.catchok_apps.base.BaseFragment
import com.example.catchok_apps.databinding.FragmentGenderBinding

class GenderFragment:BaseFragment<FragmentGenderBinding>(FragmentGenderBinding::inflate) {
    override var showBottomNavigation: Boolean = false

    override fun onBindView() {
        super.onBindView()
        binding.nextBtn.setOnClickListener {
            findNavController().navigate(
                GenderFragmentDirections.actionGenderFragmentToAgeFragment()
            )
        }
    }
}