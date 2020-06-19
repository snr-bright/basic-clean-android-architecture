package com.bright.data.entities

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

open class NewDataRealm(
    @PrimaryKey var id: String = Calendar.getInstance().timeInMillis.toString(),
    var author: String? = "",
    var title: String? = "",
    var description: String? = "",
    var url: String? = "",
    var urlToImage: String? = "",
    var source: NewSourceRealm? = null,
    var publishedDate: String? = ""
) : RealmObject()