package com.example.catchok_apps.firebase

data class SavedWorkout(
    val workout: Workout = Workout(),
    val savedTime: String = "",
    val completed:Boolean = false,
)