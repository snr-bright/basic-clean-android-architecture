package com.bright.cleanarchitecturenewsfeed

import android.app.Application
import com.bright.cleanarchitecturenewsfeed.di.*
import com.bright.cleanarchitecturenewsfeed.util.AppRealmMigration
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.RealmMigration
import org.koin.android.ext.android.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        Realm.init(this)
        val realmConfiguration = RealmConfiguration.Builder()
            .name(Realm.DEFAULT_REALM_NAME)
            .schemaVersion(7)
            .migration(AppRealmMigration())
            .deleteRealmIfMigrationNeeded()
            .build()

        Realm.setDefaultConfiguration(realmConfiguration)
        loadKoin()
    }

    private fun loadKoin() {
        startKoin(
            this,
            listOf(
                repositoriesModule,
                viewModelsModule,
                useCasesModule,
                realmModule,
                roomLocalModules
            )

        )
    }
}