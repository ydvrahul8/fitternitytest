package com.example.fitternitytest.model.personal_training

import com.example.fitternitytest.model.Campaign

data class PersonalTraining(
    val button_text: String,
    val campaign: Campaign,
    val description: String,
    val image: String,
    val link: String,
    val subtitle: String,
    val title: String
)