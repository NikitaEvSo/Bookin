package com.example.bookinf.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

val DarkColorScheme = darkColorScheme(
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

val LightColorScheme = lightColorScheme(
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
val lightCustomColors = CustomColors(
    success = Green40,
    onSuccess = Color.White,
    warning = Yellow50,
    onWarning = Neutral10,
    premiumBadge = Purple50,
    socialVk = Color(0xFF0077FF)
)

val darkCustomColors = CustomColors(
    success = Green80,
    onSuccess = Neutral10,
    warning = Yellow80,
    onWarning = Neutral10,
    premiumBadge = Purple80,
    socialVk = Color(0xFF0077FF)
)