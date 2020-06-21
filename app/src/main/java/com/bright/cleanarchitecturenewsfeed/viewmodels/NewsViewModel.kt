package com.bright.cleanarchitecturenewsfeed.viewmodels

import androidx.lifecycle.*
import com.bright.cleanarchitecturenewsfeed.entities.Data
import com.bright.cleanarchitecturenewsfeed.entities.Status
import com.bright.data.entities.NewsApiResponse
import com.bright.data.mapper.NewsMapperService
import com.bright.domain.entities.NewsDataEntity
import com.bright.domain.usecases.GetNewsUseCase
import com.bright.domain.util.EntityResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NewsViewModel(val getNewsUseCase: GetNewsUseCase) : BaseViewModel() {

    private var mutableMainState: MutableLiveData<Data<List<NewsDataEntity>>> = MutableLiveData()
    val mainState: LiveData<Data<List<NewsDataEntity>>>
        get() {
            return mutableMainState
        }


    fun getNewData() = launch {
        mutableMainState.value = Data(responseType = Status.LOADING)
        when (val result = withContext(Dispatchers.IO) { getNewsUseCase(true) }) {
            is EntityResult.Failure -> {
                mutableMainState.value = Data(responseType = Status.ERROR, error = result.exception)
            }
            is EntityResult.Success -> {
                mutableMainState.value = Data(responseType = Status.SUCCESSFUL, data = result.data)
            }
        }
    }
}


