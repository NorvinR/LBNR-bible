package com.dnorvinreyes.lbnrbible.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "books",
    primaryKeys = ["book_number"])
data class BookEntity(
    @ColumnInfo(name = "book_number") val bookNumber: Int,
    @ColumnInfo(name = "book_name") val bookName: String
)
