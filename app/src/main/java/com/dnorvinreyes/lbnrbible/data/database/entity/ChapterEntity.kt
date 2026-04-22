package com.dnorvinreyes.lbnrbible.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = "chapters",
    primaryKeys = [
        "book_number",
        "chapter_number"
    ],
    foreignKeys = [
        ForeignKey(
            entity = BookEntity::class,
            parentColumns = ["book_number"],
            childColumns = ["book_number"]
        )
    ])
data class ChapterEntity(
    @ColumnInfo(name = "book_number") val bookNumber: Int,
    @ColumnInfo(name = "chapter_number") val chapterNumber: Int
)
