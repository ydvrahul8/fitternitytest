package com.example.fitternitytest.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.fitternitytest.R
import com.example.fitternitytest.base.BaseClickListener
import com.example.fitternitytest.base.BaseViewHolder
import com.example.fitternitytest.databinding.ItemProductTagsBinding
import com.example.fitternitytest.model.ProductTags

class ProductAdapter : RecyclerView.Adapter<BaseViewHolder<*, *>>() {

    inner class ProductAdapterViewHolder(private val binding: ItemProductTagsBinding) :
        BaseViewHolder<ProductTags, BaseClickListener>(binding) {
        override fun bind(item: ProductTags, listener: BaseClickListener?) {
            binding.product = item
        }

    }

    private var list = ArrayList<ProductTags>()

    fun setData(data: ArrayList<ProductTags>) {
        list.clear()
        list.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*, *> {
        val binding = DataBindingUtil.inflate<ItemProductTagsBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_product_tags, parent, false
        )
        return ProductAdapterViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: BaseViewHolder<*, *>, position: Int) {
        when (holder) {
            is ProductAdapterViewHolder -> holder.bind(list[position])
        }

    }

}