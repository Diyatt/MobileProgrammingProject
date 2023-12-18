package com.example.catchok_apps.firebase

import com.example.catchok_apps.repository.workout.model.Workout

data class SavedWorkout(
    val workout: Workout = Workout(),
    val savedTime: String = "",
    val completed:Boolean = false,
)