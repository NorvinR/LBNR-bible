package com.dnorvinreyes.lbnrbible.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(tableName = "versiculos",
    primaryKeys = [
        "numero_libro",
        "numero_capitulo",
        "numero_versiculo"
    ],
    foreignKeys = [
        ForeignKey(
            entity = Capitulo::class,
            parentColumns = ["numero_libro", "numero_capitulo"],
            childColumns = ["numero_libro", "numero_capitulo"]
        )
    ])
data class Versiculo(
    @ColumnInfo(name = "numero_libro") val numeroLibro: Int,
    @ColumnInfo(name = "numero_capitulo") val numeroCapitulo: Int,
    @ColumnInfo(name = "numero_versiculo") val numeroVersiculo: Int,
    @ColumnInfo(name = "texto") val textoVersiculo: String
)
