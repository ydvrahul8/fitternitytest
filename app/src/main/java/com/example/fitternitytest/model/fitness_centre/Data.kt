package com.example.fitternitytest.model.fitness_centre

data class Data(
    val average_rating: Double,
    val coverimage: String,
    val location: String,
    val slug: String,
    val id: Int,
    val categorytags: List<String>,
    val category: String,
    val total_rating_count: Int,
    val flags: Flags,
    val commercial: String,
    val featured: Boolean,
    val offering_images: List<OfferingImage>,
    val trial_header: String,
    val membership_header: String,
    val membership_icon: String,
    val membership_offer: String,
    val membership_offer_default: Boolean,
    val type: String,
    val address: String,
    val title: String,
    val subcategories: List<String>,
    val tag_image: String
)