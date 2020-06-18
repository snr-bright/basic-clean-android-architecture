package com.bright.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news_data_table")
data class NewsData(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    var title: String? = null,
    var description: String? = null,
    var url: String? = null,
    var urlToImage: String? = null,
    var source: String? = null,
    var publishedDate: String? = null,
    var author: String? = null)