package com.dnorvinreyes.lbnrbible.ui.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SecondaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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

    /** Variables utiles para los tabs */
    val scope = rememberCoroutineScope ()
    var selectedTabIndex by remember { mutableIntStateOf(0) }
    val titles = listOf("Lecturas del dia", "Favoritas", "Configuraciones")
    val icons = listOf(
        R.drawable.ic_custom_dailyreading,
        R.drawable.ic_custom_favorite,
        R.drawable.ic_custom_settings
    )

    val drawerState = rememberDrawerState(DrawerValue.Closed)
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    /*
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(end = 8.dp)
                    ) {
                        Text(
                            text = "Antiguo Testamento",
                            style = MaterialTheme.typography.titleMedium
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text("Genesis")
                    }

                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(end = 8.dp)
                    ) {
                        Text(
                            text = "Nuevo Testamento",
                            style = MaterialTheme.typography.titleMedium
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text("Mateo")
                    }
                    */
                    /*LazyColumn() {
                        if (state.isLoading){
                            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                        }

                        items(libros.value.books){
                            Text(text = it.bookName)
                        }
                    }*/
                    Box(modifier = Modifier.fillMaxSize()) {
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
                    }
                }
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("BRV 1960") },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer),
                    navigationIcon = {
                        IconButton( onClick = {
                            scope.launch {
                                drawerState.open()
                            }
                        } ) { Icon(Icons.Default.Menu, contentDescription = "Menu") }
                    }
                )
            },
            bottomBar = {
                SecondaryTabRow(
                    selectedTabIndex = selectedTabIndex,
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                ) {
                    titles.forEachIndexed { index, pair ->
                        Tab(
                            selected = selectedTabIndex == index,
                            onClick = { selectedTabIndex = index },
                            icon = {
                                Icon(
                                    painter = painterResource( icons[index]),
                                    contentDescription = null
                                )
                            }
                        )
                    }
                }
            }
        ) { padding ->
            padding

            // NavigationWrapper()
        }
    }
}