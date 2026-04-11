package com.dnorvinreyes.lbnrbible.domain.repository

import com.dnorvinreyes.lbnrbible.data.database.entity.BookEntity
import com.dnorvinreyes.lbnrbible.domain.model.Chapter
import com.dnorvinreyes.lbnrbible.domain.model.Concordance
import com.dnorvinreyes.lbnrbible.domain.model.Title
import com.dnorvinreyes.lbnrbible.domain.model.Verse

interface BibleRepository {
    suspend fun getBooks(): List<BookEntity>
    suspend fun getChapters(bookNumber: Int): List<Chapter>
    suspend fun getVerses(bookNumber: Int, chapterNumber: Int): List<Verse>
    suspend fun getTitles(bookNumber: Int, chapterNumber: Int, verseNumber: Int): List<Title>
    suspend fun getConcordances(bookNumber: Int, chapterNumber: Int, verseNumber: Int): List<Concordance>
}