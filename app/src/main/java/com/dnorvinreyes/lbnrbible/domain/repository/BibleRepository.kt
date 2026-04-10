package com.dnorvinreyes.lbnrbible.domain.repository

import com.dnorvinreyes.lbnrbible.domain.model.Book
import com.dnorvinreyes.lbnrbible.domain.model.Chapter
import com.dnorvinreyes.lbnrbible.domain.model.Concordance
import com.dnorvinreyes.lbnrbible.domain.model.Title
import com.dnorvinreyes.lbnrbible.domain.model.Verse

interface BibleRepository {
    fun getBooks(): List<Book>
    fun getChapters(bookNumber: Int): List<Chapter>
    fun getVerses(bookNumber: Int, chapterNumber: Int): List<Verse>
    fun getTitles(bookNumber: Int, chapterNumber: Int, verseNumber: Int): List<Title>
    fun getConcordances(bookNumber: Int, chapterNumber: Int, verseNumber: Int): List<Concordance>
}