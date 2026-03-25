package com.example.bookinf.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.bookinf.R

val Inter = FontFamily(
    Font(R.font.intertight_regular, FontWeight.Normal),
    Font(R.font.intertight_medium, FontWeight.Medium),
    Font(R.font.intertight_semibold, FontWeight.SemiBold),
    Font(R.font.intertight_bold, FontWeight.Bold)
)

private val BaseStyle = TextStyle(
    fontFamily = Inter,
    lineHeight = 23.sp
)

val Typography = Typography(
    labelLarge = BaseStyle.copy(
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    ),
    titleSmall = BaseStyle.copy(
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp
    ),
    titleMedium = BaseStyle.copy(
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    ),
    bodyLarge = BaseStyle.copy(
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp
    ),
    bodySmall = BaseStyle.copy(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    bodyMedium = BaseStyle.copy(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    labelMedium = BaseStyle.copy(
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    ),
    labelSmall = BaseStyle.copy(
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    )
)
