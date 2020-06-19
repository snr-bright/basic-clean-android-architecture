package com.bright.data.entities

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class NewSourceRealm(
        @PrimaryKey
        var id: String? = "",
        var name: String? = ""
) : RealmObject()