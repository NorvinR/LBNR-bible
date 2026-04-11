package com.dnorvinreyes.lbnrbible.domain.usecase

import com.dnorvinreyes.lbnrbible.data.repository.BibleRepositoryImp
import com.dnorvinreyes.lbnrbible.domain.model.Book

data class GetBookUseCase(
    private val repository: BibleRepositoryImp
) {
    suspend operator fun invoke(): List<Book> {
        return repository.getBooks()
    }
}


