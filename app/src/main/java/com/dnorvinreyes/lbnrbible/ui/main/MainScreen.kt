package com.dnorvinreyes.lbnrbible.ui.main

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.dnorvinreyes.lbnrbible.R
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen (viewModel: MainViewModel = hiltViewModel()) {

    val state by viewModel.uiState.collectAsState()
    var selectedItem by remember { mutableIntStateOf(0) }

    /** Variables utiles para los tabs */
    val scope = rememberCoroutineScope ()
    val titles = listOf("Lecturas del dia", "Favoritas", "Historial", "Configuraciones")

    val drawerState = rememberDrawerState(DrawerValue.Closed)
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            // Contenido del Drawer
            ModalDrawerSheet {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        // 1. Mostrar cargando
                        if (state.isLoading){
                            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                        }
                        // 2. Mostrar error
                        if (state.errorMessage != null){
                            Text(
                                text = state.errorMessage!!,
                                color = Color.Red,
                                modifier = Modifier.align (Alignment.Center)
                            )
                        }
                        if (state.books.isNotEmpty()){
                            LazyColumn(
                                modifier = Modifier.fillMaxWidth(),
                                verticalArrangement = Arrangement.spacedBy(12.dp),
                                // 2. Agrega un margen general a los lados y arriba/abajo
                                contentPadding = PaddingValues(16.dp)
                            ) {
                                items(state.books) {
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth() // Todos ocupan el mismo ancho
                                            .border(
                                                width = 1.dp,
                                                color = Color.Gray,
                                                shape = RoundedCornerShape(8.dp)
                                            )
                                            .clip(RoundedCornerShape(8.dp)) // Recorta el efecto visual del click
                                            .clickable {
                                                /* Acción al hacer click en el libro: book */
                                            }
                                            .padding(16.dp) // Espaciado interno para que el texto no toque el borde
                                    ) {
                                        Text(
                                            text = it.bookName,
                                            style = MaterialTheme.typography.bodyLarge
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    ) {
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = { Text("BRV 1960") },
                    navigationIcon = {
                        IconButton(onClick = { scope.launch { drawerState.open() } }) {
                            Icon(Icons.Default.Menu, contentDescription = "Menu")
                        }
                    }
                )
            },
            bottomBar = {
                NavigationBar(windowInsets = NavigationBarDefaults.windowInsets) {
                    titles.forEachIndexed {index, item ->
                        val iconoAUsar = when (index) {
                            0 -> R.drawable.ic_custom_dailyreading
                            1 -> R.drawable.ic_custom_favorite
                            2 -> R.drawable.ic_custom_history
                            3 -> R.drawable.ic_custom_settings
                            else -> { Icons.Filled.Warning }
                        }
                        NavigationBarItem(
                            icon = { Icon(
                                painter = painterResource(id = iconoAUsar as Int),
                                contentDescription = item)
                                   },
                            label = {  },
                            selected = selectedItem == index,
                            onClick = {
                                selectedItem = index
                                // navController.navigate(item)
                            }
                        )
                    }
                }
            }
        ) { padding ->
            padding

            //NavigationWrapper()
        }
    }
}