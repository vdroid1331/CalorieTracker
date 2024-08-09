package com.vinayakgupta3112.calorytracker.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import com.vinayakgupta3112.calorytrackerprep.ui.theme.Typography
import com.vinayakgupta3112.core_ui.BrightGreen
import com.vinayakgupta3112.core_ui.DarkGray
import com.vinayakgupta3112.core_ui.DarkGreen
import com.vinayakgupta3112.core_ui.Dimensions
import com.vinayakgupta3112.core_ui.LightGray
import com.vinayakgupta3112.core_ui.LocalSpacing
import com.vinayakgupta3112.core_ui.MediumGray
import com.vinayakgupta3112.core_ui.Orange
import com.vinayakgupta3112.core_ui.TextWhite

private val DarkColorPalette = darkColors(
    primary = BrightGreen,
    primaryVariant = DarkGreen,
    secondary = Orange,
    background = MediumGray,
    onBackground = TextWhite,
    surface = LightGray,
    onSurface = TextWhite,
    onPrimary = Color.White,
    onSecondary = Color.White,
)

private val LightColorPalette = lightColors(
    primary = BrightGreen,
    primaryVariant = DarkGreen,
    secondary = Orange,
    background = Color.White,
    onBackground = DarkGray,
    surface = Color.White,
    onSurface = DarkGray,
    onPrimary = Color.White,
    onSecondary = Color.White,
)

@Composable
fun CaloryTrackerTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }
    CompositionLocalProvider(LocalSpacing provides Dimensions()) {
        MaterialTheme(
            colors = colors,
            typography = Typography,
            shapes = Shapes,
            content = content
        )
    }
}