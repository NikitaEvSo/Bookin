package com.example.bookinf.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.bookinf.SDUI.DrawComposableScreen
import com.example.bookinf.SDUI.UiItemDto
import com.example.bookinf.data.Room
import com.example.bookinf.ui.theme.size.AppSpacings
import com.example.bookinf.ui.theme.size.CardSizes

@Deprecated(
    message = "Use SDUIContentScreen instead for Server-Driven UI",
    replaceWith = ReplaceWith(
        expression = "SDUIContentScreen(rooms, modifier)",
        imports = ["com.example.bookinf.ui.SDUIContentScreen"]
    ),
    level = DeprecationLevel.ERROR,

)
@Composable
fun ContentScreen(rooms: List<Room>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(AppSpacings.ListGap)
    ) {
        item { Spacer(Modifier.height(AppSpacings.ListGap)) }
        item {
            MessageBlock(
                text = "Commission paid on bookings and other factors may affect property rankings. Learn about these ranking parameters and how to select and modify them. Find out more"
            )
        }
        item {
            PropertiesCountRow(count = 748)
        }
        items(rooms) { room ->
            RoomCard(room, CardSizes)
        }
        item {
            QualityRatingBlock()
        }
        item {  Spacer(Modifier.height(AppSpacings.ListGap)) }
    }
}

@Composable
fun SDUIContentScreen(uiData: List<UiItemDto>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally,

        verticalArrangement = Arrangement.spacedBy(AppSpacings.ListGap)
    ) {
        item { Spacer(Modifier.height(AppSpacings.ListGap)) }


        items(uiData) { item ->
            DrawComposableScreen(uiData = listOf(item))
        }

        item { Spacer(Modifier.height(AppSpacings.ListGap)) }
    }
}
