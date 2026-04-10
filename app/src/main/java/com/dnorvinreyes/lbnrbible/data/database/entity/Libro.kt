package com.dnorvinreyes.lbnrbible.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "libros",
    primaryKeys = ["numero_libro"])
data class Libro(
    @ColumnInfo(name = "numero_libro") val numeroLibro: Int,
    @ColumnInfo(name = "nombre_libro") val nombreLibro: String
)
