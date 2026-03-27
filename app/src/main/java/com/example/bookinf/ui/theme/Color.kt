package com.example.bookinf.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

// Базовые (Нейтральные)
val Neutral10 = Color(0xFF1A1A1A)
val Neutral20 = Color(0xFF222222)
val Neutral40 = Color(0xFF424242)
val Neutral90 = Color(0xFFE9E9E9)
val Neutral95 = Color(0xFFF5F5F5)

// Брендовые (Синие)
val Blue10 = Color(0xFF001F54)
val Blue40 = Color(0xFF003C94)
val Blue50 = Color(0xFF006CE4)
val Blue80 = Color(0xFF6F9BFD)

// Акцентные и статусные
val Green40 = Color(0xFF1C7342)
val Green80 = Color(0xFFA8D5BA)
val Yellow50 = Color(0xFFF2C94C)
val Yellow80 = Color(0xFFFFF1AC)
val Red40 = Color(0xFFB3261E)
val Purple50 = Color(0xFF8E24AA)
val Purple80 = Color(0xFFE1BEE7)

data class CustomColors(
    val success: Color,
    val onSuccess: Color,
    val warning: Color,
    val onWarning: Color,
    val premiumBadge: Color,
    val socialVk: Color
)

val LocalCustomColors = staticCompositionLocalOf {
    CustomColors(
        success = Color.Unspecified,
        onSuccess = Color.Unspecified,
        warning = Color.Unspecified,
        onWarning = Color.Unspecified,
        premiumBadge = Color.Unspecified,
        socialVk = Color.Unspecified
    )
}

val MaterialTheme.customColors: CustomColors
    @Composable
    @ReadOnlyComposable
    get() = LocalCustomColors.current

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
