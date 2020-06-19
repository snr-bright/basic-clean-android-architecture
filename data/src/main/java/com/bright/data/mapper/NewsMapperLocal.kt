package com.bright.data.mapper

import com.bright.data.entities.NewDataRealm
import com.bright.data.entities.NewSourceRealm
import com.bright.domain.entities.NewsDataEntity
import com.bright.domain.entities.NewsSourceDataEntity
import io.realm.annotations.PrimaryKey
import java.util.*

class NewsMapperLocal : BaseMapperRepository<NewDataRealm, NewsDataEntity> {

    override fun transform(type: NewDataRealm): NewsDataEntity = NewsDataEntity(
        type.author,
        type.title,
        type.description,
        type.url,
        type.urlToImage,
        type.source?.let { mapSource(it) },
        type.publishedDate
    )

    override fun transformToRepository(type: NewsDataEntity): NewDataRealm =
        NewDataRealm(
            Calendar.getInstance().timeInMillis.toString(),
            type.author,
            type.title,
            type.description,
            type.url,
            type.urlToImage,
            type.source?.let { mapSource(it) },
            type.publishedDate
        )

    private fun mapSource(source: NewSourceRealm) =
        NewsSourceDataEntity(source.id, source.name)

    private fun mapSource(source: NewsSourceDataEntity) =
        NewSourceRealm(source.id, source.name)
}
