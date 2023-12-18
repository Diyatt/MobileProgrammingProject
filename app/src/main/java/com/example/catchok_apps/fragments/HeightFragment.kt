package com.example.catchok_apps.fragments

import android.graphics.Color
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import com.example.catchok_apps.base.BaseFragment
import com.example.catchok_apps.base.SharedViewModel
import com.example.catchok_apps.databinding.FragmentHeightBinding


@AndroidEntryPoint

class HeightFragment:BaseFragment<FragmentHeightBinding>(FragmentHeightBinding::inflate) {
    private val viewModel: SharedViewModel by activityViewModels()
    override var showBottomNavigation: Boolean = false

    override fun onBindView() {
        super.onBindView()
        with(binding) {
            numberPicker.maxValue = 200
            numberPicker.minValue = 150
            numberPicker.wrapSelectorWheel = false
            numberPicker.setOnValueChangedListener { picker, oldVal, newVal ->
                viewModel.height = newVal
            }
            nextBtn.setOnClickListener {
                if(viewModel.height == null){
                    Toast.makeText(requireContext(), "Choose the value", Toast.LENGTH_SHORT).show()
                }
                else{
                    findNavController().navigate(
                        HeightFragmentDirections.actionHeightFragmentToWeightFragment()
                    )
                }

            }
        }
    }
}