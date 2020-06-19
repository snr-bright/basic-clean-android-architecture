package com.bright.data.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "news_source_table" , foreignKeys = [ForeignKey(entity = NewsApiResponse::class,
    parentColumns = ["sourceId"],
    childColumns = ["id"],
    onDelete = ForeignKey.CASCADE)]
)
data class NewsApiSource(
    @SerializedName("id") @PrimaryKey var id: String,
    @SerializedName("name") var name: String? = null
)