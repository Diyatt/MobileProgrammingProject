package com.example.catchok_apps.fragments

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint
import com.example.catchok_apps.adapter.ItemWorkoutAdapter
import com.example.catchok_apps.R
import com.example.catchok_apps.adapter.AdAdapter
import com.example.catchok_apps.repository.workout.WorkoutViewModel
import com.example.catchok_apps.base.BaseFragment
import com.example.catchok_apps.databinding.FragmentHomeBinding
import com.example.catchok_apps.firebase.UserDao
import com.example.catchok_apps.utilities.AdDao
import java.text.SimpleDateFormat
import java.util.Date
import javax.inject.Inject


@AndroidEntryPoint
class HomeFragment:BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    @Inject
    lateinit var firebaseAuth:FirebaseAuth
    private val viewModel: WorkoutViewModel by viewModels()
    @Inject
    lateinit var userDao:UserDao
    override fun onBindView() {
        userDao.getData()
        super.onBindView()
        val adapter = ItemWorkoutAdapter()
        val adAdapter = AdAdapter()

        viewModel.getWorkouts()
        with(binding){
            workoutList.adapter = adapter
            workoutList.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            data.text = "Today, ${getCurrentDate()}"

            viewModel.workoutListLiveData.observe(viewLifecycleOwner){
                adapter.submitList(it.orEmpty())
            }
            adList.adapter = adAdapter
            adList.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adAdapter.submitList(getAds())

        }
        userDao.getDataLiveData.observe(this){
            binding.greating.text = "Hello, ${it?.name}"

            if(it?.pictureUrl !=null){
                Glide.with(requireContext())
                    .load(it?.pictureUrl)
                    .into(binding.avatar)
            }
            else{
                binding.avatar.setImageResource(R.drawable.baseline_person_24)
            }
        }
        binding.seeAllBtn.setOnClickListener {
            findNavController().navigate(
                R.id.action_homeFragment_to_workoutsFragment
            )
        }
        adapter.itemClick = {workoutItem, shared->
            val extras = FragmentNavigatorExtras(*shared.toList().toTypedArray())
            val action = HomeFragmentDirections.actionHomeToWorkoutDetailsFragment(workoutItem)
            findNavController().navigate(action, extras)
        }
    }
    private fun getCurrentDate(): String {
        val currentDate = Date()
        val dateFormat = SimpleDateFormat("dd MMM")
        return dateFormat.format(currentDate)
    }


    private fun getAds():List<AdDao>{
        return listOf(
            AdDao(1, "Buy sport supplements", "10% discount", R.drawable.ad_1),
            AdDao(2, "Buy sport appliance", "0-0-12", R.drawable.ad_2),

            )
    }
}