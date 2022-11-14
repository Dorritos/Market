package com.dorritos.market.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.dorritos.market.R
import com.dorritos.market.remote.models.phones.BestSeller
import com.dorritos.market.remote.models.phones.HomeStore
import com.dorritos.market.utils.BestSellerDiffUtil
import com.dorritos.market.utils.ImageLoader

class PhoneAdapter(private val scope: LifecycleCoroutineScope) : RecyclerView.Adapter<PhoneAdapter.ViewHolder>() {

    private var itemList = listOf<BestSeller>()

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageViewPhone: ImageView = view.findViewById(R.id.imageViewPhone)
        val textViewPrice: TextView = view.findViewById(R.id.textViewPrice)
        val textViewDiscountPrice: TextView = view.findViewById(R.id.textViewDiscountPrice)
        val textViewPhoneName: TextView = view.findViewById(R.id.textViewPhoneName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.phone_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val item = getItem(position)
        viewHolder.apply {
            textViewPhoneName.text = item.title
            textViewPrice.text = item.price_without_discount.toString()
            textViewDiscountPrice.text = item.discount_price.toString()
            scope.launchWhenStarted {
                val imageUrl = item.picture + ".jpg"
                ImageLoader.setImage(imageUrl, imageViewPhone)
            }
        }
    }

    override fun getItemCount(): Int = itemList.size

    private fun getItem(position: Int): BestSeller = itemList[position]

    fun setItems(items: List<BestSeller>){
        val result = DiffUtil.calculateDiff(BestSellerDiffUtil(itemList, items))
        itemList = items
        result.dispatchUpdatesTo(this)

    }

}