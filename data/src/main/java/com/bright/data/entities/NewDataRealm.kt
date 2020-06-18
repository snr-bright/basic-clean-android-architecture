package com.bright.data.entities

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class NewDataRealm(
        @PrimaryKey
        var id: String? = "",
        var title: String? = "",
        var url: String? = "",
        var urlToImage: String? = "",
        var source: String = "",
        var publishedDate: String? = "",
        var author: String? = "",
        var description: String? = ""
) : RealmObject()