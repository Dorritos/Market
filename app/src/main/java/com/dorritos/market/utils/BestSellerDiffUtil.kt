package com.dorritos.market.utils

import androidx.recyclerview.widget.DiffUtil
import com.dorritos.market.remote.models.phones.BestSeller

class BestSellerDiffUtil(
    private val oldList: List<BestSeller>,
    private val newList: List<BestSeller>,
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}
