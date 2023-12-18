package com.example.catchok_apps.fragments

import android.os.Build
import android.view.View
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import com.example.catchok_apps.R
import com.example.catchok_apps.base.BaseFragment
import com.example.catchok_apps.base.SharedViewModel
import com.example.catchok_apps.databinding.FragmentGoalBinding
import com.example.catchok_apps.firebase.Goal



@AndroidEntryPoint
class GoalFragment:BaseFragment<FragmentGoalBinding>(FragmentGoalBinding::inflate) {
    private val viewModel: SharedViewModel by activityViewModels()
    override var showBottomNavigation: Boolean = false

    override fun onBindView() {
        super.onBindView()
        with(binding) {
            val goals = arrayOf(
                "Gain Muscles", "Get fitter", "Lose weight"
            )
            numberPicker.minValue = 0
            numberPicker.maxValue = goals.size -1
            numberPicker.wrapSelectorWheel = false
            numberPicker.displayedValues = goals
            numberPicker.setOnValueChangedListener { _, _, newVal ->
                viewModel.goal = Goal.values()[newVal]
            }
            nextBtn.setOnClickListener {
                findNavController().navigate(
                    GoalFragmentDirections.actionGoalFragmentToLevelFragment()
                )
            }
        }
    }

}