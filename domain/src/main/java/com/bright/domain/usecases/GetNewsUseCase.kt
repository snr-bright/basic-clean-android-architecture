package com.bright.domain.usecases

import com.bright.domain.repositories.GetNewsRepository
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

class GetNewsUseCase: KoinComponent {
    private val getNewsRepository: GetNewsRepository by inject()
    operator fun invoke(getFromRemote: Boolean) = getNewsRepository.getNews(getFromRemote)
}
