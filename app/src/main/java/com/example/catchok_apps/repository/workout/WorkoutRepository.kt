package com.example.catchok_apps.repository.workout


interface WorkoutRepository {
    suspend fun getWorkoutList():List<Workout>?

    suspend fun getWorkoutListByTarget(target:String):List<Workout>?

}