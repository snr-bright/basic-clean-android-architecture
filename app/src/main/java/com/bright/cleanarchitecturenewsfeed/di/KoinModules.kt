package com.bright.cleanarchitecturenewsfeed.di

import com.bright.cleanarchitecturenewsfeed.viewmodels.NewsViewModel
import com.bright.data.api.RemoteNewsService
import com.bright.data.db.NewsDataDao
import com.bright.data.mapper.NewsMapperLocal
import com.bright.data.repositories.GetNewsRepositoryImpl
import com.bright.domain.repositories.GetNewsRepository
import com.bright.domain.usecases.GetNewsUseCase
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val repositoriesModule = module {
    single { RemoteNewsService() }
    single { NewsDataDao() }
    single { NewsMapperLocal() }
    single<GetNewsRepository> { GetNewsRepositoryImpl(get(), get(), get()) }
}

val viewModelsModule = module {
    viewModel { NewsViewModel(get()) }
}

val useCasesModule = module {
    single { GetNewsUseCase() }
}