package com.dnorvinreyes.lbnrbible

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dnorvinreyes.lbnrbible.data.database.db.AppDatabase
import com.dnorvinreyes.lbnrbible.data.repository.BibleRepositoryImp
import com.dnorvinreyes.lbnrbible.ui.main.MainScreen
import com.dnorvinreyes.lbnrbible.ui.main.MainViewModel
import com.dnorvinreyes.lbnrbible.ui.theme.LBNRBibleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = AppDatabase.getDatabase(applicationContext)

        val repository = BibleRepositoryImp(
            db.libroDao(),
            db.capituloDao()
        )


        enableEdgeToEdge()
        setContent {
            val viewModel: MainViewModel = viewModel(
                factory = object : ViewModelProvider.Factory {
                    override fun <T : ViewModel> create(modelClass: Class<T>): T {
                        return MainViewModel(repository) as T
                    }
                }
            )
            LBNRBibleTheme {
                MainScreen(viewModel = viewModel)
            }
        }
    }
}
