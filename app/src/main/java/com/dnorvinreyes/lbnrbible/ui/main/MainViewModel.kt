package com.dnorvinreyes.lbnrbible.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dnorvinreyes.lbnrbible.domain.usecase.GetBookUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor (
    private val getBookUseCase: GetBookUseCase
) : ViewModel() {
    // 1. La variable interna que mutamos
    private val _uiState = MutableStateFlow(MainUiState())
    // 2. La variable pública que el Composable observa (inmutable)
    val uiState: StateFlow<MainUiState> = _uiState.asStateFlow()

    init {
        fetchBooks()
    }

    private fun fetchBooks(){
        viewModelScope.launch {
            // Empezamos cargando
            _uiState.update { it.copy(isLoading = true) }
            try {
                val books = getBookUseCase()
                _uiState.update { it.copy(books = books, isLoading = false) }
            }catch (e: Exception){
                // Manejo de errores
                _uiState.update { it.copy(
                    errorMessage = "Error al cargar libros | ${e.cause}",
                    isLoading = false
                ) }
            }
        }
    }
}