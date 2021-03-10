package com.example.fitternitytest.model.upcoming_classes_home

import com.example.fitternitytest.model.upcoming_classes_studio.Address

data class Data(
    val average_rating: Double,
    val name: String,
    val slug: String,
    val vendor_slug: String,
    val vendor_name: String,
    val coverimage: String,
    val best_seller: Boolean,
    val booking_points: Int,
    val city: String,
    val commercial: String,
    //val flags: Flags?=null,
    val id: Int,
    val live_location: String,
    val live_location_icon: String,
    val next_slot: String,
    val overlay_details: List<OverlayDetail>,
    val overlayimage: String,
    val overlayimage_v2: OverlayimageV2,
    val pps_oneliner: String,
    val service_type: String,
    val session_time: Int,
    val special_price: Int,
    val total_rating_count: Int,
    val address: Address,
    val campaign_text: String,
    //val flags: Flags,
    val location: String,
    val tag_image: String,
    val total_slots: String
)