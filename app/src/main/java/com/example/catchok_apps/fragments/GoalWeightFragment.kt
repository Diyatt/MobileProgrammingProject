package com.example.catchok_apps.fragments

import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import com.example.catchok_apps.base.BaseFragment
import com.example.catchok_apps.base.SharedViewModel
import com.example.catchok_apps.databinding.FragmentGoalWeightBinding


@AndroidEntryPoint
class GoalWeightFragment:BaseFragment<FragmentGoalWeightBinding>(FragmentGoalWeightBinding::inflate) {

    private val viewModel: SharedViewModel by activityViewModels()
    override var showBottomNavigation: Boolean = false
    override fun onBindView() {
        super.onBindView()
        with(binding) {
            numberPicker.maxValue = 200
            numberPicker.minValue = 40
            numberPicker.wrapSelectorWheel = false
            numberPicker.setOnValueChangedListener { picker, oldVal, newVal ->
                viewModel.goalWeight = newVal
            }
            nextBtn.setOnClickListener {
                findNavController().navigate(
                    GoalWeightFragmentDirections.actionGoalWeightFragmentToGoalFragment()
                )
            }
        }
    }
}