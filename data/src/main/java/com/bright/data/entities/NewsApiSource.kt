package com.bright.data.entities

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "news_source_table")
data class NewsApiSource(
    @SerializedName("id")  var id: String? = "",
    @SerializedName("name") var name: String? = null
)