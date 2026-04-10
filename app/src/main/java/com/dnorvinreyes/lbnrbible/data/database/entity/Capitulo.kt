package com.dnorvinreyes.lbnrbible.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = "capitulos",
    primaryKeys = [
        "numero_libro",
        "numero_capitulo"
    ],
    foreignKeys = [
        ForeignKey(
            entity = Libro::class,
            parentColumns = ["numero_libro"],
            childColumns = ["numero_libro"]
        )
    ])
data class Capitulo(
    @ColumnInfo(name = "numero_libro") val numeroLibro: Int,
    @ColumnInfo(name = "numero_capitulo") val numeroCapitulo: Int
)
