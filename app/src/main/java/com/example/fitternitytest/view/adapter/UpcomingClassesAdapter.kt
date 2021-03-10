package com.example.fitternitytest.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.fitternitytest.R
import com.example.fitternitytest.base.BaseClickListener
import com.example.fitternitytest.base.BaseViewHolder
import com.example.fitternitytest.databinding.ItemUpcomingClassesBinding
import com.example.fitternitytest.model.upcoming_classes_home.Data

class UpcomingClassesAdapter  : RecyclerView.Adapter<BaseViewHolder<*, *>>() {

    inner class UpcomingClassesViewHolder(private val binding: ItemUpcomingClassesBinding) :
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
        val binding = DataBindingUtil.inflate<ItemUpcomingClassesBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_upcoming_classes, parent, false
        )
        return UpcomingClassesViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: BaseViewHolder<*, *>, position: Int) {
        when (holder) {
            is UpcomingClassesViewHolder -> holder.bind(list[position])
        }

    }

}