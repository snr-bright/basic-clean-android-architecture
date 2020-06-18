package com.bright.cleanarchitecturenewsfeed

import android.app.Application
import com.bright.cleanarchitecturenewsfeed.di.*
import io.realm.Realm
import org.koin.android.ext.android.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        Realm.init(this)

        loadKoin()
    }

    private fun loadKoin() {
        startKoin(
            this,
            listOf(
                repositoriesModule,
                viewModelsModule,
                useCasesModule
            )

        )
    }
}