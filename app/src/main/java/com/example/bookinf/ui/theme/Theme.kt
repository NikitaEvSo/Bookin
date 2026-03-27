package com.example.bookinf.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = Blue80,
    onPrimary = Neutral10,
    primaryContainer = Blue10,
    onPrimaryContainer = Color.White,
    secondary = Yellow80,
    onSecondary = Neutral10,
    tertiary = Green80,
    onTertiary = Neutral10,
    error = Red40,
    onError = Color.White,
    background = Neutral10,
    onBackground = Neutral95,
    surface = Neutral20,
    onSurface = Neutral95,
    surfaceVariant = Neutral40,
    onSurfaceVariant = Neutral90
)

private val LightColorScheme = lightColorScheme(
    primary = Blue40,
    onPrimary = Color.White,
    primaryContainer = Blue10,
    onPrimaryContainer = Color.White,
    secondary = Yellow50,
    onSecondary = Neutral10,
    secondaryContainer = Yellow50.copy(alpha = 0.2f),
    onSecondaryContainer = Neutral10,
    tertiary = Green40,
    onTertiary = Color.White,
    error = Red40,
    onError = Color.White,
    background = Neutral95,
    onBackground = Neutral10,
    surface = Color.White,
    onSurface = Neutral10,
    surfaceVariant = Neutral90,
    onSurfaceVariant = Neutral40
)

@Composable
fun BookinfTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme =
        when{
            dynamicColor && Build.VERSION.SDK_INT>=Build.VERSION_CODES.S -> {
                if (darkTheme) dynamicDarkColorScheme(LocalContext.current) else dynamicLightColorScheme(LocalContext.current)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val customColors = if (darkTheme) darkCustomColors else lightCustomColors
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    CompositionLocalProvider(
        LocalCustomColors provides customColors
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            content = content
        )
    }
}
