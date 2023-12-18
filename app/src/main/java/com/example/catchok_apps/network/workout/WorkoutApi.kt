package com.example.catchok_apps.network.workout


import com.example.catchok_apps.repository.workout.model.Workout
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface WorkoutApi {
    @GET("exercises?limit=50")
    suspend fun getExercises(
    ):Response<List<Workout>>

    @GET("exercises/target/{target}")
    suspend fun getExercisesByTarget(
        @Path("target") target:String,
    ):Response<List<Workout>>


}