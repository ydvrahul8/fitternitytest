package com.example.fitternitytest.model.categories

import com.example.fitternitytest.model.Campaign

data class Categories(
    val all_category_title: String,
    val campaign: Campaign,
    val categorytags: List<Categorytag>,
    val max_category: Int,
    val text: String,
    val title: String
)