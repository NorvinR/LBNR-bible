package com.dnorvinreyes.lbnrbible

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.dnorvinreyes.lbnrbible.data.database.db.AppDatabase
import com.dnorvinreyes.lbnrbible.ui.main.MainScreen
import com.dnorvinreyes.lbnrbible.ui.theme.LBNRBibleTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LBNRBibleTheme {
                MainScreen()
            }
        }
    }
}
