package com.dnorvinreyes.lbnrbible.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dnorvinreyes.lbnrbible.HomeScreen
import com.dnorvinreyes.lbnrbible.LoginScreen

@Composable
fun NavigationWrapper() {
    /** El navController es quien administra el stack trace */
    val navController = rememberNavController()

    /** Contenedor de la pantalla que se esta mostrando al usuario */
    NavHost(navController, startDestination = Login){
        composable<Login>{

            /** Cuando la funcion lambda es la primera o la ultima podemos omitir
             * los parenticis */
            LoginScreen { navController.navigate(Home) }
        }

        composable<Home>{
            HomeScreen { name ->
                navController.navigate(Detail(name = name))
            }
        }

        composable<Detail>{
            DetailScreen()
        }
    }
}