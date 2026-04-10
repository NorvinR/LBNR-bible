package com.dnorvinreyes.lbnrbible.domain.model

data class Concordance(
    val bookNumber: Int,
    val chapterNumber: Int,
    val verseNumber: Int,
    val text: String
)
