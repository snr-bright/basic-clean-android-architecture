package com.bright.data.db

import android.content.Context
import androidx.room.Room

class DatabaseInstance private constructor() {

    companion object {
        @Volatile
        private var instance: NewsDatabase? = null

        fun getInstance(context: Context): NewsDatabase {
            synchronized(lock = this) {
                var localInstance: NewsDatabase? = instance
                if (localInstance == null) {
                    localInstance =
                        Room.databaseBuilder(
                            context.applicationContext,
                            NewsDatabase::class.java,
                            "news_articles"
                        )
                            .build()
                }
                return localInstance
            }
        }
    }


}