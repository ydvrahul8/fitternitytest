package com.example.fitternitytest.utils

import com.example.fitternitytest.base.BaseClickListener

interface OnClickListener : BaseClickListener {
    public fun onItemClickListener(position:Int)
}