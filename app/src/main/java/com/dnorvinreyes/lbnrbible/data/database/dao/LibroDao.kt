package com.dnorvinreyes.lbnrbible.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.dnorvinreyes.lbnrbible.data.database.entity.BookEntity

@Dao
interface LibroDao {
    @Query("SELECT * FROM libros order by 1")
    suspend fun getAllLibros(): List<BookEntity>
}
