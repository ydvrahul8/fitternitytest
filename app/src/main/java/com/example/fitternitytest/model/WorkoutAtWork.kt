package com.example.fitternitytest.model

import com.example.fitternitytest.model.categories.Categories
import com.example.fitternitytest.model.fitness_centre.FitnessCentres
import com.example.fitternitytest.model.onepass.OnepassPre
import com.example.fitternitytest.model.upcoming_classes_studio.UpcomingClasses

data class WorkoutAtWork(
    val city_name: String,
    val city_id: Int,
    val instudio: String,
    val product_tags: List<ProductTags>,
    val campaigns: List<Campaigns>,
    val categories: Categories,
    val onepass_pre: OnepassPre,
    val upcoming_classes: UpcomingClasses,
    val fitness_centres: FitnessCentres,
    val section_orders: List<String>
)