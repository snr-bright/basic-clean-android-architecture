package com.bright.cleanarchitecturenewsfeed.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.bright.cleanarchitecturenewsfeed.R
import com.bright.cleanarchitecturenewsfeed.adapter.FeedAdapter
import com.bright.cleanarchitecturenewsfeed.entities.Data
import com.bright.cleanarchitecturenewsfeed.entities.Status
import com.bright.cleanarchitecturenewsfeed.viewmodels.NewsViewModel
import com.bright.domain.entities.NewsDataEntity
import kotlinx.android.synthetic.main.activity_news.*
import org.koin.android.viewmodel.ext.android.viewModel

class NewsActivity : AppCompatActivity() {

    private val viewModel by viewModel<NewsViewModel>()
    private lateinit var listAdapter: FeedAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        bindView()

        viewModel.mainState.observe(::getLifecycle, ::updateUI)

        viewModel.getNewData()
    }

    private fun bindView() {
        listAdapter = FeedAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = listAdapter
    }

    //MARK: update
    private fun updateUI(result: Data<List<NewsDataEntity>>) {
        when (result.responseType) {
            Status.ERROR -> {
                contentLoadingProgressBar.visibility = View.INVISIBLE
                textViewError.visibility = View.INVISIBLE
                result.error?.message?.let {
                    textViewError.text = it
                }
            }
            Status.LOADING -> {
                contentLoadingProgressBar.visibility = View.VISIBLE
                textViewError.visibility = View.VISIBLE
            }
            Status.SUCCESSFUL -> {
                contentLoadingProgressBar.visibility = View.INVISIBLE
                textViewError.visibility = View.INVISIBLE
                result.data?.let {
                    listAdapter.updateList(it)
                }
            }
        }
    }
}