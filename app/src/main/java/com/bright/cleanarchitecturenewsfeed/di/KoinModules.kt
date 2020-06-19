package com.bright.cleanarchitecturenewsfeed.di

import androidx.room.Room
import com.bright.cleanarchitecturenewsfeed.viewmodels.NewsViewModel
import com.bright.data.api.RemoteNewsService
import com.bright.data.database.realm.NewsDataDao
import com.bright.data.database.room.AppDatabase
import com.bright.data.mapper.NewsMapperLocal
import com.bright.data.repositories.GetNewsRepositoryImpl
import com.bright.domain.repositories.GetNewsRepository
import com.bright.domain.usecases.GetNewsUseCase
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module


private const val RETROFIT_INSTANCE = "Retrofit"
private const val GET_NEWS_USECASE = "getNewsUseCase"
private const val ROOM_DATABASE = "room_database"
private const val REALM_DATABASE = "realm_database"
private const val LOCAL_MAPPER = "local_mapper"

val repositoriesModule = module {
    single(name = RETROFIT_INSTANCE) { RemoteNewsService() }
    single(name = LOCAL_MAPPER) { NewsMapperLocal() }
    single<GetNewsRepository> {
        GetNewsRepositoryImpl(
            get(REALM_DATABASE),
            get(RETROFIT_INSTANCE),
            get(LOCAL_MAPPER)
        )
    }
}

val realmModule = module {
    single(name = REALM_DATABASE) { NewsDataDao() }
}
val viewModelsModule = module {
    viewModel { NewsViewModel(get(GET_NEWS_USECASE))}
}
val useCasesModule = module {
    single(name = GET_NEWS_USECASE) { GetNewsUseCase() }
}
val roomLocalModules = module {
    single(name = ROOM_DATABASE) {
        Room.databaseBuilder(androidApplication(), AppDatabase::class.java, "app_database").build()
    }
}