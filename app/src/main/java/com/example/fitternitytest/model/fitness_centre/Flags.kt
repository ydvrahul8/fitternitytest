package com.example.fitternitytest.model.fitness_centre

data class Flags(
    val trial: String,
    val membership: String,
    val top_selling: Boolean,
    val newly_launched: Boolean,
    val opening_soon: Boolean,
    val coming_on_onepass: Boolean,
    val state: String,
    val featured: Boolean,
    val april5: Boolean,
    val not_available_on_onepass: Boolean,
    val forced_on_onepass: Boolean,
    val lite_classpass_available: Boolean,
    val covid_state: String,
    val covid_state_id: Int,
    val covid_state_immediately: Boolean,
    val monsoon_flash_discount: String,
    val monsoon_flash_discount_disabled: Boolean,
    val monsoon_flash_discount_per: Int,
    val hyper_local_list: List<String>
)