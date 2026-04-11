package com.dnorvinreyes.lbnrbible.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(tableName = "concordancias",
    primaryKeys = [
        "numero_libro",
        "numero_capitulo",
        "numero_versiculo"
    ],
    foreignKeys = [
        ForeignKey(
            entity = VerseEntity::class,
            parentColumns = ["numero_libro", "numero_capitulo", "numero_versiculo"],
            childColumns = ["numero_libro", "numero_capitulo", "numero_versiculo"]
        )
    ])
data class ConcordanceEntity(
    @ColumnInfo(name = "numero_libro") val numeroLibro: Int,
    @ColumnInfo(name = "numero_capitulo") val numeroCapitulo: Int,
    @ColumnInfo(name = "numero_versiculo") val numeroVersiculo: Int,
    @ColumnInfo(name = "texto") val textoConcordancia: String
)
