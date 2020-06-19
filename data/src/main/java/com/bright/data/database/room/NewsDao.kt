package com.bright.data.database.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bright.data.entities.NewsApiResponse

@Dao
interface NewsDao{

    @Query("Select * from news_table")
     fun getAllNews(): List<NewsApiResponse>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun saveAllNews(articles: List<NewsApiResponse>)

    @Query("DELETE FROM news_table")
     fun clear()

}