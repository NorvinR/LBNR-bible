package com.dnorvinreyes.lbnrbible.ui.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dnorvinreyes.lbnrbible.data.database.entity.BookEntity
import com.dnorvinreyes.lbnrbible.data.repository.BibleRepositoryImp
import kotlinx.coroutines.launch

class MainViewModel (
    private val repository: BibleRepositoryImp
) : ViewModel() {
    var bookEntities by mutableStateOf<List<BookEntity>>(emptyList())
        private set

    init {
        cargarLibros()
    }

    private fun cargarLibros(){
        viewModelScope.launch {
            bookEntities = repository.getBooks()
        }
    }
}