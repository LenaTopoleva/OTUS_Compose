package com.example.cupcake

import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun CupcakeApp(onToggleTheme: () -> Unit, darkTheme: Boolean) {
    CupcakesAppTheme(darkTheme = darkTheme) {
        Surface(color = AppTheme.colors.background) {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "start") {
                    composable("start") {
                        StartScreen(navHostController = navController)
                    }
//                    composable("flavor") {
//                        FlavorScreen(navHostController = navController, onToggleTheme = onToggleTheme)
//                    }
//                    composable("pickup") {
//                        PickupScreen(navHostController = navController)
//                    }
//                    composable("summary") {
//                        SummaryScreen(navHostController = navController)
//                    }
//                }
            }
        }
    }
}