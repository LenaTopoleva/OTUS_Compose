import androidx.compose.material.Colors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

object AppColors {
    val primary = Color(0xFFEC407A)
    val onPrimary = Color(0xFFFFFFFF)
    val secondary = Color(0xFFAB47BC)
    val onPrimaryReverse = Color(0xFF141414)
    val background = Color(0xFFFFFFFF)
    val backgroundReverse = Color(0xFF141414)
    val onSurface = Color(0xFFA9A9A9)
    val toolbarText = Color(0xFFE7E7E7)
    val text = Color(0xFF111111)
    val textReverse = Color(0xFFEEEEEE)
}

interface ColorPalette {
    val primary: Color
    val onPrimary: Color
    val background: Color
    val toolbar: Color
    val toolbarText: Color
    val text: Color

    val materialColors: Colors
}

fun lightColorPalette(): ColorPalette = object : ColorPalette {
    override val primary: Color = AppColors.primary
    override val onPrimary: Color = AppColors.onPrimary
    override val background: Color = AppColors.background
    override val toolbar: Color = AppColors.primary
    override val toolbarText: Color = AppColors.toolbarText
    override val text: Color = AppColors.text

    override val materialColors: Colors = lightColors(
        primary = AppColors.primary,
        surface = AppColors.backgroundReverse,
        onSurface = AppColors.onSurface,
        secondary = AppColors.secondary
    )
}

fun darkColorPalette(): ColorPalette = object : ColorPalette {
    override val primary: Color = AppColors.primary
    override val onPrimary: Color = AppColors.onPrimaryReverse
    override val background: Color = AppColors.backgroundReverse
    override val toolbar: Color = AppColors.backgroundReverse
    override val toolbarText: Color = AppColors.toolbarText
    override val text: Color = AppColors.textReverse

    override val materialColors: Colors = lightColors(
        primary = AppColors.primary,
        surface = AppColors.background,
        onSurface = AppColors.onSurface,
        secondary = AppColors.secondary
    )
}