package com.dnorvinreyes.lbnrbible.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.dnorvinreyes.lbnrbible.data.database.entity.ChapterEntity

@Dao
interface ChapterDao {
    @Query("SELECT * FROM capitulos WHERE numero_libro = :bookNumber order by 1")
    suspend fun getAllChapters(bookNumber: Int): List<ChapterEntity>
}
