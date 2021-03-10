package com.example.fitternitytest.model.upcoming_classes_home

import com.example.fitternitytest.model.Campaign

data class UpcomingClasses(
    val button_text: String,
    val campaign: Campaign,
    val data: List<Data>,
    val description: String,
    val session_type: String,
    val title: String
)