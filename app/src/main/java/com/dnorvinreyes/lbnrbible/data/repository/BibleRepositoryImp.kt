package com.dnorvinreyes.lbnrbible.data.repository
import com.dnorvinreyes.lbnrbible.data.database.dao.LibroDao
import com.dnorvinreyes.lbnrbible.data.database.entity.BookEntity
import com.dnorvinreyes.lbnrbible.domain.model.Chapter
import com.dnorvinreyes.lbnrbible.domain.model.Concordance
import com.dnorvinreyes.lbnrbible.domain.model.Title
import com.dnorvinreyes.lbnrbible.domain.model.Verse
import com.dnorvinreyes.lbnrbible.domain.repository.BibleRepository

/*
class BibleRepositoryImp(
    private val bookDao: LibroDao,
    private val chapterDao: CapituloDao
) {
    // Libros
    suspend fun getBooks(): List<Libro>{
        return bookDao.getAllLibros()
    }
}
*/

class BibleRepositoryImp(
    private val bookDao: LibroDao
) : BibleRepository {
    override suspend fun getBooks(): List<BookEntity> {
        val books =  bookDao.getAllLibros()
        return books.map {
            BookEntity(it.numeroLibro, it.nombreLibro)
        }
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
