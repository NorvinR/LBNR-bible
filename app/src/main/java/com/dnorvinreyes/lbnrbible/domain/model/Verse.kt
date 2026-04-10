package com.dnorvinreyes.lbnrbible.domain.model

data class Verse(
    val bookNumber: Int,
    val chapterNumber: Int,
    val verseNumber: Int,
    val text: String
)
