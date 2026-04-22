package com.dnorvinreyes.lbnrbible.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.dnorvinreyes.lbnrbible.data.database.entity.ChapterEntity

@Dao
interface ChapterDao {
    @Query("SELECT * FROM chapters WHERE book_number = :bookNumber order by 1")
    suspend fun getAllChapters(bookNumber: Int): List<ChapterEntity>
}
