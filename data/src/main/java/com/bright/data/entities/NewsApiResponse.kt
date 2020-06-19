package com.bright.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "news_table")
data class NewsApiResponse(
    @SerializedName("author") var author: String? = "",
    @SerializedName("title") var title: String? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("url") var url: String? = null,
    @SerializedName("urlToImage") var urlToImage: String? = null,
    @SerializedName("source") @Ignore var source: NewsApiSource? = null,
    @SerializedName("publishedDate") var publishedDate: String? = null,
    @PrimaryKey
    @ColumnInfo(name = "sourceId", index = true)
    var sourceId: String = ""
)