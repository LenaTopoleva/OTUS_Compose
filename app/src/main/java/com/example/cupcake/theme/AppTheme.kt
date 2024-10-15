package com.example.cupcake.theme

import ColorPalette
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import darkColorPalette
import lightColorPalette

@Composable
fun CupcakesAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
){
    val colors = if (darkTheme) darkColorPalette() else lightColorPalette()
    val typography = AppTypography()
    CompositionLocalProvider(
        LocalColor provides colors,
        LocalTypography provides typography
    ) {
        MaterialTheme(
            colors = colors.materialColors,
            typography = typography.materialTypography,
            content = content
        )
    }
}

object AppTheme {

    val colors: ColorPalette
        @Composable get() = LocalColor.current

    val typography: AppTypography
        @Composable get() = LocalTypography.current
}

internal val LocalColor = staticCompositionLocalOf { lightColorPalette() }
internal val LocalTypography = staticCompositionLocalOf { AppTypography() }

