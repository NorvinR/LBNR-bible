package com.dnorvinreyes.lbnrbible.domain.usecase

import com.dnorvinreyes.lbnrbible.domain.model.Book
import com.dnorvinreyes.lbnrbible.domain.repository.BibleRepository
import javax.inject.Inject

class GetBookUseCase @Inject constructor(
    private val repository: BibleRepository
) {
    suspend operator fun invoke(): List<Book> {
        return repository.getBooks()
    }
}
