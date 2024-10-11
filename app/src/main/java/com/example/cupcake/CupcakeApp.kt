package com.example.cupcake

import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun CupcakeApp() {
    CupcakesAppTheme() {
        Surface(color = AppTheme.colors.background) {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "start") {
                    composable("start") {
                        StartScreen(navHostController = navController)
                    }
                    composable(
                        route = "flavor/{quantity}",
                        arguments = listOf(navArgument("quantity") {type = NavType.IntType})
                        ) {
                            backStackEntry ->
                        backStackEntry.arguments?.getInt("quantity")?.let {
                            FlavorScreen(navHostController = navController, quantity = it)
                        }
                    }
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