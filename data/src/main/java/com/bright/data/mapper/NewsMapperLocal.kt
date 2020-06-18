package com.bright.data.mapper

import com.bright.data.entities.NewDataRealm
import com.bright.domain.entities.NewsDataEntity

class NewsMapperLocal : BaseMapperRepository<NewDataRealm, NewsDataEntity> {

    override fun transform(type: NewDataRealm): NewsDataEntity = NewsDataEntity(
        type.id,
        type.title,
        type.description
    )

    override fun transformToRepository(type: NewsDataEntity): NewDataRealm =
        NewDataRealm(
            type.id,
            type.title,
            type.description
        )
}
