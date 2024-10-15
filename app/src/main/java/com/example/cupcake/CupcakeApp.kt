package com.example.cupcake

import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cupcake.model.OrderViewModel
import com.example.cupcake.screens.FlavorScreen
import com.example.cupcake.screens.PickupScreen
import com.example.cupcake.screens.StartScreen
import com.example.cupcake.screens.SummaryScreen
import com.example.cupcake.theme.AppTheme
import com.example.cupcake.theme.CupcakesAppTheme

@Composable
fun CupcakeApp(viewModel: OrderViewModel, sendOrderCallback: () -> Unit) {
    CupcakesAppTheme() {
        Surface(color = AppTheme.colors.background) {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = START_SCREEN) {
                    composable(START_SCREEN) {
                        StartScreen(navHostController = navController, viewModel = viewModel)
                    }
                    composable(FLAVOR_SCREEN) {
                          FlavorScreen(navHostController = navController, viewModel = viewModel)
                        }
                    composable(PICKUP_SCREEN) {
                        PickupScreen(navHostController = navController, viewModel = viewModel)
                    }
                    composable(SUMMARY_SCREEN) {
                        SummaryScreen(navHostController = navController, viewModel = viewModel, sendOrderCallback)
                    }
                }
            }
    }
}

const val START_SCREEN = "start"
const val FLAVOR_SCREEN = "flavor"
const val PICKUP_SCREEN = "pickup"
const val SUMMARY_SCREEN = "summary"