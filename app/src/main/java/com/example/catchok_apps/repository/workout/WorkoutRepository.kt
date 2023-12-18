package com.example.catchok_apps.repository.workout

import com.example.catchok_apps.repository.workout.model.Workout


interface WorkoutRepository {
    suspend fun getWorkoutList():List<Workout>?

    suspend fun getWorkoutListByTarget(target:String):List<Workout>?

}