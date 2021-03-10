package com.example.fitternitytest.view.fragment.location

import com.example.fitternitytest.R
import com.example.fitternitytest.databinding.FragmentLocationBinding
import com.example.fitternitytest.base.BaseFragment
import com.example.fitternitytest.model.Location
import com.example.fitternitytest.utils.VerticalSpacingItemDecoration
import com.example.fitternitytest.view.adapter.LocationAdapter
import javax.inject.Inject

class LocationFragment : BaseFragment<FragmentLocationBinding>() {

    override val layout: Int
        get() = R.layout.fragment_location

    @Inject
    lateinit var adapter: LocationAdapter

    override fun init(bind: FragmentLocationBinding) {
        bind.listener = this
        bind.recyclerViewLocation.addItemDecoration(VerticalSpacingItemDecoration(4))
        bind.recyclerViewLocation.adapter = adapter
        setData()
    }

    private fun setData() {
        adapter.setData(Location.getData())
    }

    fun backButtonPressed() {
        requireActivity().onBackPressed()
    }
}