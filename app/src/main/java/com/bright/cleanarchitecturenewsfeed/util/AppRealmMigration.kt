package com.bright.cleanarchitecturenewsfeed.util

import io.realm.DynamicRealm
import io.realm.FieldAttribute
import io.realm.RealmMigration
import io.realm.RealmObjectSchema




/**
 * Created by Monarchy on 03/11/2017.
 */
class AppRealmMigration : RealmMigration {

    override fun migrate(realm: DynamicRealm?, oldVersion: Long, newVersion: Long) {
        // Access the Realm schema in order to create, modify or delete classes and their fields.
        val schema = realm!!.schema
        if (oldVersion == 4L) {

        }

    }
}