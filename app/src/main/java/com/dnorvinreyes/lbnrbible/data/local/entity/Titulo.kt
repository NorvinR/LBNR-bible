package com.dnorvinreyes.lbnrbible.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "titulos")
data class Titulo(
    @ColumnInfo(name = "numero_libro") val numeroLibro: String,
    @ColumnInfo(name = "numero_capitulo") val numeroCapitulo: String,
    @ColumnInfo(name = "numero_versiculo") val numeroVersiculo: String,
    @ColumnInfo(name = "texto") val texto: String
)
