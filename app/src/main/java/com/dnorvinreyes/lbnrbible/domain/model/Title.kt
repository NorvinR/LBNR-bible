package com.dnorvinreyes.lbnrbible.domain.model

data class Title(
    val bookNumber: Int,
    val chapterNumber: Int,
    val verseNumber: Int,
    val text: String
)
