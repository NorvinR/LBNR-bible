package com.dnorvinreyes.lbnrbible.ui.main

import com.dnorvinreyes.lbnrbible.domain.model.Book

data class MainUiState(
    val isLoading: Boolean = false,
    val books: List<Book> = emptyList(),
    val errorMessage: String? = null
)