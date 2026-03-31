package com.example.bookinf.ui.theme.size


import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Size(
    val width: Dp = Dp.Unspecified,
    val height: Dp = Dp.Unspecified,
)

data class OneSize(
    val size: Dp = Dp.Unspecified
)
//размеры для компонентов width height и дочерних компонентов
data class SizeSpec(
    val baseSize: Size = Size(),
    val contentSize: Size = Size(),
    val iconSize: OneSize = OneSize()
)

object AppSizes {
    val Card = SizeSpec(
        baseSize = Size(
            width = 550.dp,
            height = 393.dp
        ),
        contentSize = Size(
            width = 118.dp,
            height = 308.dp
        ),
        iconSize = OneSize(
            size = 17.dp
        )
    )
}
val CardSizes get() = AppSizes.Card