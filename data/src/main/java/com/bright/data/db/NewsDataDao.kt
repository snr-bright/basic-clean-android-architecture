package com.bright.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.bright.data.entities.NewsData
import io.reactivex.Flowable

@Dao
interface NewsDataDao {

    @Query("Select * from news_data_table")
    fun getAllNewsData(): Flowable<List<NewsData>?>

//    @Query("Select * from news_data_table")
//    fun getAllNewsData(): LiveData<List<NewsData>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAllNewsData(newDataList: List<NewsData>)

    @Query("DELETE FROM news_data_table")
    fun clear()

    @Delete()
    fun delete(newData: NewsData)

    @Update()
    fun update(newData: NewsData)

    @Insert()
    fun addData(newData: NewsData)

}