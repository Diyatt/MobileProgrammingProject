package com.example.catchok_apps.base

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.catchok_apps.firebase.SavedWorkout
import com.example.catchok_apps.repository.gpt.model.Choice
import com.example.catchok_apps.repository.workout.model.Workout
import com.example.catchok_apps.utilities.AdDao

abstract class BaseViewHolder<VB:ViewBinding, T>(protected open val binding:VB):
    RecyclerView.ViewHolder(binding.root){
    abstract fun bindView(item:T)
}



abstract class BaseWorkoutViewHolder<VB:ViewBinding>(override val binding: VB):
    BaseViewHolder<VB, Workout>(binding)

abstract class BaseAdViewHolder<VB:ViewBinding>(override val binding: VB):
    BaseViewHolder<VB, AdDao>(binding)


abstract class BaseSavedWorkoutViewHolder<VB:ViewBinding>(override val binding: VB):
    BaseViewHolder<VB, SavedWorkout>(binding)


abstract class BaseMessageViewHolder<VB:ViewBinding>(override val binding:VB):
    BaseViewHolder<VB, Choice>(binding)