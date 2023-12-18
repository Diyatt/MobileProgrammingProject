package com.example.catchok_apps.fragments

import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import com.example.catchok_apps.base.BaseFragment
import com.example.catchok_apps.databinding.FragmentStartworkoutBinding
import com.example.catchok_apps.firebase.UserDao
import javax.inject.Inject


@AndroidEntryPoint
class StartWorkoutFragment:BaseFragment<FragmentStartworkoutBinding>(FragmentStartworkoutBinding::inflate) {

    private val args:StartWorkoutFragmentArgs by navArgs()
    @Inject
    lateinit var userDao:UserDao
    override fun onBindView() {
        super.onBindView()
        with(binding){
            startBtn.setOnClickListener {
                showCustomDialog("Congratulations!", "You've finished this exercise")
            }
            backBtn.setOnClickListener {
                findNavController().popBackStack()
            }
            Glide.with(requireContext())
                .load(args.workoutItem.gifUrl)
                .into(gif)
            instructions.text = args.workoutItem.instructions?.joinToString(separator = " ")
        }
    }

}