package com.bright.data.database.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bright.data.entities.NewsApiResponse
import com.bright.data.entities.NewsApiSource

@Database(entities = [NewsApiResponse::class, NewsApiSource::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getNewsDao(): NewsDao
    abstract fun getNewsSourceDao(): NewsSourceDao
}