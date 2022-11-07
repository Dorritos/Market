package com.dorritos.market.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.recyclerview.widget.RecyclerView
import com.dorritos.market.R
import com.dorritos.market.remote.models.phones.Phones
import com.dorritos.market.utils.ImageLoader

class BannerAdapter(private val scope: LifecycleCoroutineScope) : RecyclerView.Adapter<BannerAdapter.ViewHolder>() {

    private var itemList = listOf<Phones>()

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val bannerImageView: ImageView = view.findViewById(R.id.imageViewBanner)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.banner_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val item = getItem(position)
        viewHolder.apply {
            scope.launchWhenStarted {
                val imageUrl = item.best_seller.first().picture + ".jpg"
                ImageLoader.setImage(imageUrl, bannerImageView)
            }
        }
    }

        override fun getItemCount(): Int = itemList.size

        private fun getItem(position: Int): Phones = itemList[position]

}
