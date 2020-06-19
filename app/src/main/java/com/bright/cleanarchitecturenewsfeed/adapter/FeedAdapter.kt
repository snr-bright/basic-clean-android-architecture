package com.bright.cleanarchitecturenewsfeed.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import coil.transform.BlurTransformation
import coil.transform.CircleCropTransformation
import com.bright.cleanarchitecturenewsfeed.R
import com.bright.domain.entities.NewsDataEntity
import com.squareup.picasso.Picasso


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
        return constant
    }


    //MARK: configure the device
    private fun configureViewHolder(viewHolder: ViewHolderNews, data: NewsDataEntity) {
        val textViewTitle = viewHolder.textViewTitle
        val textViewAuthor = viewHolder.textViewAuthor
        val imageView = viewHolder.imageView

        textViewTitle?.text = data.title
        textViewAuthor?.text = data.author
        Picasso.get()
            .load(data.urlToImage)
            .placeholder(R.drawable.ic_image_placeholder)
            .error(R.drawable.ic_image_placeholder)
            .into(imageView)

    }

    class ViewHolderNews(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView? = null
        var textViewTitle: TextView? = null
        var textViewAuthor: TextView? = null

        init {
            textViewAuthor = itemView.findViewById(R.id.textViewAuthor)
            textViewTitle = itemView.findViewById(R.id.textViewTitle)
            imageView = itemView.findViewById(R.id.imageView)
        }
    }

    fun updateList(list: List<NewsDataEntity>) {
        items.addAll(list)
        notifyDataSetChanged()
    }
}