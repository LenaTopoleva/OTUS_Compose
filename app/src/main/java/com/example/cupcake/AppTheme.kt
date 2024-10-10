package com.example.cupcake

import ColorPalette
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import darkColorPalette
import lightColorPalette

@Composable
fun CupcakesAppTheme(
    darkTheme: Boolean,
    content: @Composable() () -> Unit
){
    val colors = if (darkTheme) darkColorPalette() else lightColorPalette()
    CompositionLocalProvider(
        LocalColor provides colors,
    ) {
        MaterialTheme(
            colors = colors.materialColors,
        ) {
            content()
        }
    }
}

object AppTheme {

    val colors: ColorPalette
        @Composable get() = LocalColor.current
}

internal val LocalColor = staticCompositionLocalOf { lightColorPalette() }