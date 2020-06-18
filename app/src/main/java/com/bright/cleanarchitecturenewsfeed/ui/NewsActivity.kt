package com.bright.cleanarchitecturenewsfeed.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bright.cleanarchitecturenewsfeed.R
import com.bright.cleanarchitecturenewsfeed.entities.Data
import com.bright.cleanarchitecturenewsfeed.entities.Status
import com.bright.cleanarchitecturenewsfeed.viewmodels.NewsViewModel
import com.bright.domain.entities.NewsDataEntity
import org.koin.android.viewmodel.ext.android.viewModel

class NewsActivity : AppCompatActivity() {

    private val viewModel by viewModel<NewsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        viewModel.mainState.observe(::getLifecycle, ::updateUI)

        viewModel.getNewData()
    }

    private fun updateUI(result: Data<List<NewsDataEntity>>) {
        when (result.responseType) {
            Status.ERROR -> {
                Log.e("NEWS", result.error.toString())
                //hideProgress()
                result.error?.message?.let {
                    Log.e("NEWS", it)
                }
            }
            Status.LOADING -> {
                Log.e("NEWS", "LOADING")
                // showProgress()
            }
            Status.SUCCESSFUL -> {
                Log.e("NEWS", "SUCCESS")
                //hideProgress()
                result.data?.let {
                    Log.e("NEWS", it.toString())
                }
            }
        }
    }
}