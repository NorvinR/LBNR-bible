package com.dnorvinreyes.lbnrbible.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(tableName = "titulos",
    primaryKeys = [
        "numero_libro",
        "numero_capitulo",
        "numero_versiculo"
    ],
    foreignKeys = [
        ForeignKey(
            entity = Versiculo::class,
            parentColumns = ["numero_libro", "numero_capitulo", "numero_versiculo"],
            childColumns = ["numero_libro", "numero_capitulo", "numero_versiculo"]
        )
    ])
data class Titulo(
    @ColumnInfo(name = "numero_libro") val numeroLibro: Int,
    @ColumnInfo(name = "numero_capitulo") val numeroCapitulo: Int,
    @ColumnInfo(name = "numero_versiculo") val numeroVersiculo: Int,
    @ColumnInfo(name = "texto") val textoTitulo: String
)
