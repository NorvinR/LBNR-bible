package com.dnorvinreyes.lbnrbible.data.repository
import com.dnorvinreyes.lbnrbible.data.database.dao.BookDao
import com.dnorvinreyes.lbnrbible.data.mapper.toDomain
import com.dnorvinreyes.lbnrbible.domain.model.Book
import com.dnorvinreyes.lbnrbible.domain.model.Chapter
import com.dnorvinreyes.lbnrbible.domain.model.Concordance
import com.dnorvinreyes.lbnrbible.domain.model.Title
import com.dnorvinreyes.lbnrbible.domain.model.Verse
import com.dnorvinreyes.lbnrbible.domain.repository.BibleRepository
import javax.inject.Inject


class BibleRepositoryImp @Inject constructor (
    private val bookDao: BookDao // Hilt sacara esto de RoomModule
) : BibleRepository {
    override suspend fun getBooks(): List<Book> {
        val books =  bookDao.getAllBooks()
        return books.map { it.toDomain() }
    }

    override suspend fun getChapters(bookNumber: Int): List<Chapter> {
        TODO("Not yet implemented")
    }

    override suspend fun getVerses(
        bookNumber: Int,
        chapterNumber: Int
    ): List<Verse> {
        TODO("Not yet implemented")
    }

    override suspend fun getTitles(
        bookNumber: Int,
        chapterNumber: Int,
        verseNumber: Int
    ): List<Title> {
        TODO("Not yet implemented")
    }

    override suspend fun getConcordances(
        bookNumber: Int,
        chapterNumber: Int,
        verseNumber: Int
    ): List<Concordance> {
        TODO("Not yet implemented")
    }
}
