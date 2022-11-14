package com.dorritos.market.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.recyclerview.widget.RecyclerView
import com.dorritos.market.R
import com.dorritos.market.remote.models.phones.BestSeller
import com.dorritos.market.remote.models.phones.HomeStore
import com.dorritos.market.utils.ImageLoader

class BannerAdapter(private val scope: LifecycleCoroutineScope) : RecyclerView.Adapter<BannerAdapter.ViewHolder>() {

    private var itemList = listOf<HomeStore>()

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val bannerImageView: ImageView = view.findViewById(R.id.imageViewBanner)
        val textViewPhoneName: TextView = view.findViewById(R.id.textViewPhoneName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.banner_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val item = getItem(position)
        viewHolder.apply {
            textViewPhoneName.text = item.title
            scope.launchWhenStarted {
                val imageUrl = item.picture + ".jpg"
                ImageLoader.setImage(imageUrl, bannerImageView)
            }
        }
    }

        override fun getItemCount(): Int = itemList.size

        private fun getItem(position: Int): HomeStore = itemList[position]

}
