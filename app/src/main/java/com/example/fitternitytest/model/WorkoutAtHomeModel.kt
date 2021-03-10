package com.example.fitternitytest.model

import com.example.fitternitytest.model.challenge.Challenge
import com.example.fitternitytest.model.fit_tv.FitTv
import com.example.fitternitytest.model.onepass.OnepassPre
import com.example.fitternitytest.model.personal_training.PersonalTraining
import com.example.fitternitytest.model.upcoming_classes_home.UpcomingClasses

data class WorkoutAtHomeModel(
    val city_name: String,
    val city_id: Int,
    val instudio: String,
    val product_tags: List<ProductTags>,
    val campaigns: List<Campaigns>,
    val onepass_pre: OnepassPre,
    val personal_training: PersonalTraining,
    val upcoming_classes: UpcomingClasses,
    val challenge: Challenge,
    val fit_tv: FitTv,
    val section_orders: List<String>
)