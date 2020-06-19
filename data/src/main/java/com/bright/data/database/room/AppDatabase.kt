package com.bright.data.database.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.bright.data.entities.NewsApiResponse
import com.bright.data.entities.NewsApiSource

@Database(entities = [NewsApiResponse::class, NewsApiSource::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getNewsDao(): NewsDao
    abstract fun getNewsSourceDao(): NewsSourceDao

    companion object {
        const val VERSION = 2

        val migrationRoom: Migration = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                //This is where the magic happends
            }
        }
    }
}