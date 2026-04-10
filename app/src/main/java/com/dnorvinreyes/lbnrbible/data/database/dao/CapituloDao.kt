package com.dnorvinreyes.lbnrbible.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.dnorvinreyes.lbnrbible.data.database.entity.Capitulo

@Dao
interface CapituloDao {
    @Query("SELECT * FROM capitulos WHERE numero_libro = :numeroLibro order by 1")
    suspend fun getAllCapitulos(numeroLibro: Int): List<Capitulo>
}
