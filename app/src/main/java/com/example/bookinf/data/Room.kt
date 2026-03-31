package com.example.bookinf.data

import com.example.bookinf.R

data class Room(
    val id: Int,
    val title: String,
    val score: Float,
    val reviews: Int,
    val distanceMeters: Int,
    val stars: Int,
    val discountedCost: Int,
    val originalCost: Int,
    val tags: List<String> = emptyList(),
    val isPrepaymentNeeded: Boolean,
    var isFavorite: Boolean = false
) {
    val ratingResId: Int
        get() = when {
            score > 8 -> R.string.rating_fabulous
            score > 7 -> R.string.rating_good
            else -> R.string.rating_na
        }
}
