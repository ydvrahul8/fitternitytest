package com.example.fitternitytest.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.fitternitytest.R
import com.example.fitternitytest.base.BaseClickListener
import com.example.fitternitytest.base.BaseViewHolder
import com.example.fitternitytest.base.OnClickHandler
import com.example.fitternitytest.databinding.ItemDiscoverBinding
import com.example.fitternitytest.model.categories.Categorytag
import javax.inject.Inject

class CategoryTagAdapter @Inject constructor(val clickHandler: OnClickHandler)  : RecyclerView.Adapter<BaseViewHolder<*, *>>() {


    inner class CategoryTagViewHolder(private val binding: ItemDiscoverBinding) :
        BaseViewHolder<Categorytag, BaseClickListener>(binding) {
        override fun bind(item: Categorytag, listener: BaseClickListener?) {
            binding.category = item
            binding.listener = clickHandler
        }

    }

    private var list = ArrayList<Categorytag>()

    fun setData(data: ArrayList<Categorytag>) {
        list.clear()
        list.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*, *> {
        val binding = DataBindingUtil.inflate<ItemDiscoverBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_discover, parent, false
        )
        return CategoryTagViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: BaseViewHolder<*, *>, position: Int) {
        when (holder) {
            is CategoryTagViewHolder -> holder.bind(list[position])
        }

    }

}