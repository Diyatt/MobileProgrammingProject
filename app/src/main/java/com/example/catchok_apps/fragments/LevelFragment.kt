package com.example.catchok_apps.fragments

import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import com.example.catchok_apps.base.BaseFragment
import com.example.catchok_apps.base.SharedViewModel
import com.example.catchok_apps.databinding.FragmentLevelBinding
import com.example.catchok_apps.firebase.Goal
import com.example.catchok_apps.firebase.Level


@AndroidEntryPoint
class LevelFragment:BaseFragment<FragmentLevelBinding>(FragmentLevelBinding::inflate) {

    private val viewModel: SharedViewModel by activityViewModels()
    override var showBottomNavigation: Boolean = false
    override fun onBindView() {
        super.onBindView()
        with(binding) {
            val goals = arrayOf(
                "Beginner", "Intermediate", "Advance"
            )
            numberPicker.minValue = 0
            numberPicker.maxValue = goals.size -1
            numberPicker.wrapSelectorWheel = false
            numberPicker.displayedValues = goals
            numberPicker.setOnValueChangedListener { _, _, newVal ->
                viewModel.level = Level.values()[newVal]
            }
            nextBtn.setOnClickListener {
                findNavController().navigate(
                    LevelFragmentDirections.actionLevelFragmentToUserInformationFragment()
                )
            }
        }
    }
}