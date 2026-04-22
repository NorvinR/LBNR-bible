package com.dnorvinreyes.lbnrbible.data.mapper

import com.dnorvinreyes.lbnrbible.data.database.entity.BookEntity
import com.dnorvinreyes.lbnrbible.domain.model.Book

fun BookEntity.toDomain() = Book(
    bookNumber = bookNumber,
    bookName = bookName
)