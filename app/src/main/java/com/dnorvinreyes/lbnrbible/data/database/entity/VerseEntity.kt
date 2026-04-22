package com.dnorvinreyes.lbnrbible.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(tableName = "verses",
    primaryKeys = [
        "book_number",
        "chapter_number",
        "verse_number"
    ],
    foreignKeys = [
        ForeignKey(
            entity = ChapterEntity::class,
            parentColumns = ["book_number", "chapter_number"],
            childColumns = ["book_number", "chapter_number"]
        )
    ])
data class VerseEntity(
    @ColumnInfo(name = "book_number") val bookNumber: Int,
    @ColumnInfo(name = "chapter_number") val chapterNumber: Int,
    @ColumnInfo(name = "verse_number") val verseNumber: Int,
    @ColumnInfo(name = "text") val text: String
)
