package com.example.fitternitytest.model.fit_tv

import com.example.fitternitytest.model.Campaign

data class FitTv(
    val button_text: String,
    val campaign: Campaign,
    val data: List<Data>,
    val description: String,
    val title: String
)