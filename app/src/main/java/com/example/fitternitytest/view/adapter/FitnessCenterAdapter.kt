package com.example.fitternitytest.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.fitternitytest.R
import com.example.fitternitytest.base.BaseClickListener
import com.example.fitternitytest.base.BaseViewHolder
import com.example.fitternitytest.databinding.ItemFitnessCenterBinding
import com.example.fitternitytest.model.fitness_centre.Data

class FitnessCenterAdapter : RecyclerView.Adapter<BaseViewHolder<*, *>>() {

    inner class FitnessCenterViewHolder(private val binding: ItemFitnessCenterBinding) :
        BaseViewHolder<Data, BaseClickListener>(binding) {
        override fun bind(item: Data, listener: BaseClickListener?) {
            binding.data = item
        }

    }

    private var list = ArrayList<Data>()

    fun setData(data: ArrayList<Data>) {
        list.clear()
        list.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*, *> {
        val binding = DataBindingUtil.inflate<ItemFitnessCenterBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_fitness_center, parent, false
        )
        return FitnessCenterViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: BaseViewHolder<*, *>, position: Int) {
        when (holder) {
            is FitnessCenterViewHolder -> holder.bind(list[position])
        }

    }

}