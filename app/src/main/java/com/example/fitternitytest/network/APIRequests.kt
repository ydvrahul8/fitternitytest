package com.example.fitternitytest.network

import com.example.fitternitytest.model.WorkoutAtHomeModel
import com.example.fitternitytest.model.WorkoutAtWork
import retrofit2.http.GET

interface APIRequests {

    @GET("homescreenapi/HomeScreenAtHome.json")
    suspend fun getWorkoutAtHome(): WorkoutAtHomeModel

    @GET("homescreenapi/HomeScreenInStudio.json")
    suspend fun getWorkoutAtStudio(): WorkoutAtWork

}