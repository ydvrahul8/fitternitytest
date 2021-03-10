package com.example.fitternitytest.model.upcoming_classes_studio

import com.example.fitternitytest.model.Campaign
import com.example.fitternitytest.model.upcoming_classes_home.Data

data class UpcomingClasses(
    val button_text: String,
    val campaign: Campaign,
    val data: List<Data>,
    val description: String,
    val session_type: String,
    val title: String
)