package com.example.bookinf.data

import java.util.Locale

data class Room(
    val title: String,
    val score: Float,
    val reviews: Int,
    val distanceMeters: Int,
    val stars: Int,
    val discountedCost: Int,
    val originalCost: Int,
    val tags: List<GreenTag> = emptyList(),
    val isPrepaymentNeeded: Boolean
) {
    val ratingText: String
        get() = when {
            score > 8 -> "Fabulous"
            score > 7 -> "Good"
            else -> "N/A"
        }

    val formattedDistance: String
        get() = if (distanceMeters >= 1000) {
            String.format(Locale.US, "%.1f km from centre", distanceMeters / 1000.0)
        } else {
            "${distanceMeters}m from centre"
        }
}

data class GreenTag(
    val text: String
)
