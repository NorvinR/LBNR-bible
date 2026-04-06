package com.dnorvinreyes.lbnrbible.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "libros")
data class Libro(
    @ColumnInfo(name = "numero_libro") val numeroLibro: String,
    @ColumnInfo(name = "nombre_libro") val nombreLibro: String
)
