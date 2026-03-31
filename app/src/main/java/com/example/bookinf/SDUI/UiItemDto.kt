package com.example.bookinf.SDUI

enum class ComposableType {
    MESSAGE_BLOCK,
    PROPERTIES_COUNT,
    QUALITY_RATING,
    ROOM_CARDS,
    ROOM_CARD,
    HEADER,
    BANNER,
    SPACER,
    DIVIDER,
    SEARCH_BAR,
    FILTER_BAR,
    BUTTON,
    IMAGE
}

data class UiItemDto(
    val type: String,
    val data: Map<String, Any>? = null
)
