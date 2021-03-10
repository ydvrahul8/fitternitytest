package com.example.fitternitytest.model.onepass

import com.example.fitternitytest.model.Campaign

data class OnepassPre(
    val button_text: String,
    val campaign: Campaign,
    val header_img: String,
    val passes: Passes
)