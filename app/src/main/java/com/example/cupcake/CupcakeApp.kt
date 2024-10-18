package com.example.cupcake

import  androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
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
            NavHost(
                navController = navController,
                startDestination = START_SCREEN,
                enterTransition = { EnterTransition.None },
                exitTransition = { ExitTransition.None }
            ) {
                val enterTransition: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition?) =
                    {
                        fadeIn(
                            animationSpec = tween(
                                300, easing = LinearEasing
                            )
                        ) + slideIntoContainer(
                            animationSpec = tween(300, easing = EaseIn),
                            towards = AnimatedContentTransitionScope.SlideDirection.Start
                        )
                    }
                val exitTransition: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition?) =
                    {
                        fadeOut(
                            animationSpec = tween(
                                300, easing = LinearEasing
                            )
                        ) + slideOutOfContainer(
                            animationSpec = tween(300, easing = EaseOut),
                            towards = AnimatedContentTransitionScope.SlideDirection.End
                        )
                    }

                composable(START_SCREEN) {
                    StartScreen(navHostController = navController, viewModel = viewModel)
                }

                composable(
                    route = FLAVOR_SCREEN,
                    enterTransition = enterTransition,
                    exitTransition = exitTransition
                ) {
                    FlavorScreen(navHostController = navController, viewModel = viewModel)
                }

                composable(
                    route = PICKUP_SCREEN,
                    enterTransition = enterTransition,
                    exitTransition = exitTransition
                ) {
                    PickupScreen(navHostController = navController, viewModel = viewModel)
                }

                composable(
                    route = SUMMARY_SCREEN,
                    enterTransition = enterTransition,
                    exitTransition = exitTransition
                ) {
                    SummaryScreen(
                        navHostController = navController,
                        viewModel = viewModel,
                        sendOrderCallback
                    )
                }
            }
        }
    }
}

const val START_SCREEN = "start"
const val FLAVOR_SCREEN = "flavor"
const val PICKUP_SCREEN = "pickup"
const val SUMMARY_SCREEN = "summary"