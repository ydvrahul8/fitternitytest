package com.example.fitternitytest.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.fitternitytest.R
import com.example.fitternitytest.base.BaseViewHolder
import com.example.fitternitytest.base.OnClickHandler
import com.example.fitternitytest.databinding.ItemLocationBinding
import com.example.fitternitytest.model.Location
import com.example.fitternitytest.utils.OnClickListener
import javax.inject.Inject

class LocationAdapter @Inject constructor(val clickHandler: OnClickHandler) : RecyclerView.Adapter<BaseViewHolder<*, *>>() {

    inner class LocationViewHolder(private val binding: ItemLocationBinding) :
        BaseViewHolder<Location, OnClickListener>(binding) {
            override fun bind(item: Location, listener: OnClickListener?) {
            binding.location = item
            binding.listener = clickHandler
        }
    }

    private var data = ArrayList<Location>()

    fun setData(list: ArrayList<Location>) {
        data.clear()
        data.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*, *> {
        val binding = DataBindingUtil.inflate<ItemLocationBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_location,
            parent,
            false
        )
        return LocationViewHolder(binding)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: BaseViewHolder<*, *>, position: Int) {
        when (holder) {
            is LocationViewHolder -> holder.bind(data[position])
        }
    }
}