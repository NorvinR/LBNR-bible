package com.dnorvinreyes.lbnrbible.data.repository

import com.dnorvinreyes.lbnrbible.data.database.dao.CapituloDao
import com.dnorvinreyes.lbnrbible.data.database.dao.LibroDao
import com.dnorvinreyes.lbnrbible.data.database.entity.Libro

class BibleRepositoryImp(
    private val bookDao: LibroDao,
    private val chapterDao: CapituloDao
) {
    // Libros
    suspend fun getBooks(): List<Libro>{
        return bookDao.getAllLibros()
    }
}
