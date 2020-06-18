package com.bright.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [NewsDataDao::class], version = 1)
abstract class NewsDatabase : RoomDatabase() {
    abstract fun getNewsDao(): NewsDataDao
}