package com.example.fitternitytest.model.onepass

data class Passes(
    val desc_header: String,
    val description: String,
    val header1: String,
    val header1_color: String,
    val header2: String,
    val header2_color: String,
    val image: String,
    val onepass_type: String,
    val subtitle: String? = null,
    val subheader: String
)