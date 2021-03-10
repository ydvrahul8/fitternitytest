package com.example.fitternitytest.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Location (val id: Int, val location: String) : Parcelable {
    companion object {
        fun getData(): ArrayList<Location> {
            val list = ArrayList<Location>()
            list.add(Location(1, "Mumbai"))
            list.add(Location(1, "Pune"))
            list.add(Location(1, "Delhi"))
            list.add(Location(1, "Banglore"))
            return list
        }
    }
}