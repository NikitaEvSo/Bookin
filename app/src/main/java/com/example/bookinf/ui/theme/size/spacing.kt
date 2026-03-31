package com.example.bookinf.ui.theme.size

import androidx.compose.ui.unit.dp

/**
 * Базовые значения отступов (raw values).
 */
object Spacing {
    val None = 0.dp
    val Tiny = 4.dp
    val Small = 8.dp
    val Medium = 16.dp
    val Large = 24.dp
    val ExtraLarge = 32.dp
}

/**
 * Семантические отступы для всего приложения.
 * Используйте их, чтобы менять дизайн сразу во всех местах.
 */
object AppSpacings {
    val ScreenMargin = Spacing.Medium
    val CardPadding = Spacing.Small
    val ContentGap = Spacing.Tiny
    val SectionGap = Spacing.Large
    val ListGap = Spacing.Small
}

