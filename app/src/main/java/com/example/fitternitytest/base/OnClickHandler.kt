package com.example.fitternitytest.base

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.navigation.findNavController
import com.example.fitternitytest.model.Location
import com.example.fitternitytest.view.dialog.DetailDialog
import com.example.fitternitytest.view.fragment.home.HomeFragmentDirections
import com.example.fitternitytest.view.fragment.location.LocationFragmentDirections
import javax.inject.Inject


class OnClickHandler @Inject constructor() {
    fun showLocation(view: View) {
        val action =
            HomeFragmentDirections.actionHomeFragmentToLocationFragment()
        view.findNavController().navigate(action)
    }

    fun onLocationClick(view: View, location: Location) {
        val data = LocationFragmentDirections.actionLocationFragmentToHomeFragment(location)
        view.findNavController().navigate(data)
    }


    fun showDialog(view: View, title: String, description: String) {
        val manager =(view.context as AppCompatActivity).supportFragmentManager

        DetailDialog.Builder()
            .description(description)
            .title(title)
            .isCancellable(false)
            .build()
            .show(manager, "")
    }
}