package com.bright.data.database.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bright.data.entities.NewsApiSource

@Dao
interface NewsSourceDao {

    @Query("Select * from news_source_table")
    fun getAllNewsSources(): List<NewsApiSource>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAllNews(articles: List<NewsApiSource>)

    @Query("DELETE FROM news_source_table")
    fun clear()

}