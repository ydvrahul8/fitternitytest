package com.example.fitternitytest.model.challenge

import com.example.fitternitytest.model.Campaign

data class Challenge(
    val campaign: Campaign,
    val data: List<Data>,
    val description: String,
    val title: String
)