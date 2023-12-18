package com.example.catchok_apps.fragments

import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import com.example.catchok_apps.base.BaseFragment
import com.example.catchok_apps.SharedViewModel
import com.example.catchok_apps.databinding.FragmentAgeBinding


@AndroidEntryPoint
class AgeFragment:BaseFragment<FragmentAgeBinding>(FragmentAgeBinding::inflate) {

    private val viewModel:SharedViewModel by activityViewModels()
    override var showBottomNavigation: Boolean = false

    override fun onBindView() {
        with(binding){
            numberPicker.maxValue = 100
            numberPicker.minValue = 18
            numberPicker.wrapSelectorWheel = false
            numberPicker.setOnValueChangedListener { picker, oldVal, newVal ->
                viewModel.age = newVal
            }
            nextBtn.setOnClickListener {
                findNavController().navigate(
                    AgeFragmentDirections.actionAgeFragmentToHeightFragment()
                )
            }
        }

    }

}