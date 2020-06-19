package com.bright.cleanarchitecturenewsfeed.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bright.cleanarchitecturenewsfeed.R
import com.bright.domain.entities.NewsDataEntity


/**
 * Created by Monarchy on 09/10/2017.
 */


class FeedAdapter() :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val constant = 100
    private var items = mutableListOf<NewsDataEntity>()

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var viewHolder: RecyclerView.ViewHolder? = null
        val inflater = LayoutInflater.from(viewGroup.context)
        when (viewType) {
            constant -> {
                val viewHolderItem = inflater.inflate(R.layout.news_feed_item, viewGroup, false)
                viewHolder = ViewHolderNews(viewHolderItem)
            }
        }
        return viewHolder!!
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            constant -> {
                val viewHolderMallBanner = holder as ViewHolderNews
                configureViewHolder(viewHolderMallBanner, items[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return this.items.size
    }


    override fun getItemViewType(position: Int): Int {
        return when {
            items[position] is NewsDataEntity -> constant
            else -> -1
        }
    }


    //MARK: configure the device
    private fun configureViewHolder(viewHolder: ViewHolderNews, data: NewsDataEntity) {
        val textViewTitle = viewHolder.textViewTitle
        val imageViewDeal = viewHolder.imageView

        textViewTitle?.text = data.title
    }

    class ViewHolderNews(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView? = null
        var textViewTitle: TextView? = null

        init {
            textViewTitle = itemView.findViewById(R.id.textViewTitle)
            imageView = itemView.findViewById(R.id.imageView)
        }
    }

    fun updateList(list: List<NewsDataEntity>) {
        items.addAll(list)
        notifyDataSetChanged()
    }
}