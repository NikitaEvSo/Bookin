package com.example.bookinf.ui

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.bookinf.R
import com.example.bookinf.data.Room
import com.example.bookinf.ui.theme.size.AppSpacings
import com.example.bookinf.ui.theme.size.SizeSpec
import com.example.bookinf.ui.theme.size.Spacing
import com.example.bookinf.ui.theme.customColors

@Composable
fun RoomCard(room: Room, sizes: SizeSpec, modifier: Modifier = Modifier) {
    val iconModifier = Modifier.size(sizes.iconSize.size)
    Surface(
        modifier = modifier
            .width(sizes.baseSize.width)
            .clickable(
                onClick = {
                    Log.d("RoomCard", "Room clicked: ${room.title}")
                }),
        color = MaterialTheme.colorScheme.surface
    ) {
        Card{
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(AppSpacings.CardPadding),
                    horizontalArrangement = Arrangement.spacedBy(AppSpacings.CardPadding),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Image placeholder
                    Box(
                        modifier = Modifier
                            .width(sizes.contentSize.width)
                            .height(sizes.contentSize.height)
                            .background(
                                color = MaterialTheme.colorScheme.tertiary,
                                shape = RoundedCornerShape(6.dp)
                            )
                    )

                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .height(sizes.contentSize.height),
                    ) {
                        TopInfoSection(room, iconModifier)
                        Spacer(modifier = Modifier.height(AppSpacings.SectionGap))
                        BottomPriceSection(room,iconModifier)
                    }
                }
            }
        }
    }
        Spacer(modifier = Modifier.height(AppSpacings.ListGap))

}

@Composable
private fun TopInfoSection(room: Room, iconModifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(AppSpacings.ContentGap)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = room.title,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.weight(1f)
            )
            Favorite(initialFavorite = room.isFavorite,iconModifier)
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(AppSpacings.ContentGap)
        ) {
            repeat(room.stars) {
                Icon(
                    painter = painterResource(R.drawable.star),
                    contentDescription = null,
                    tint = MaterialTheme.customColors.warning,
                    modifier = iconModifier
                )
            }
            Image(
                painter = painterResource(R.drawable.thumb),
                contentDescription = null,
                modifier = iconModifier
            )
            Image(
                painter = painterResource(id = R.drawable.genius),
                contentDescription = "Genius",
                modifier = Modifier
                    .width(56.dp)
                    .height(20.dp)
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(Spacing.Small)
        ) {
            RatingBox(score = room.score.toString())

            Text(
                text = stringResource(room.ratingResId),
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onSurface,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.weight(1f, fill = false)
            )
            DotSeparator()
            Text(
                text = stringResource(R.string.reviews_count, room.reviews),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 1,
                overflow = TextOverflow.Clip
            )
        }
        LocationAndCertification(room, iconModifier)
        room.tags.forEach { tag ->
            TagLabel(tag)
        }
    }
}

@Composable
private fun Favorite(initialFavorite: Boolean, iconModifier: Modifier) {
    var isFavorite by remember { mutableStateOf(initialFavorite) }
    Icon(
        imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
        contentDescription = "Favorite",
        modifier = iconModifier.clickable(onClick = { isFavorite = !isFavorite }),
        tint = MaterialTheme.colorScheme.onSurfaceVariant
    )
    //animation
}

@Composable
private fun LocationAndCertification(room: Room, iconModifier: Modifier) {
    Column(verticalArrangement = Arrangement.spacedBy(Spacing.None)) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(AppSpacings.ContentGap)
        ) {
            Icon(
                imageVector = Icons.Default.LocationOn,
                contentDescription = null,
                modifier = iconModifier,
                tint = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = stringResource(R.string.example),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
            DotSeparator(size = 3.dp, color = MaterialTheme.colorScheme.onSurface)
            Text(
                text = stringResource(R.string.distance_km, room.distanceMeters / 1000.0) ,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(AppSpacings.ContentGap)
        ) {
            Icon(
                imageVector = Icons.Default.CheckCircle,
                contentDescription = null,
                modifier = iconModifier,
                tint = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = stringResource(R.string.sustainability_certification),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}

@Composable
private fun BottomPriceSection(room: Room,iconModifier: Modifier) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.spacedBy(AppSpacings.ContentGap)
    ) {
        Text(
            text = stringResource( R.string.bed_count),
            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
            color = MaterialTheme.colorScheme.onSurface,
            textAlign = TextAlign.End
        )
        Text(
            text = stringResource( R.string.price_for),
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onSurface,
            textAlign = TextAlign.End
        )
        PriceRow(room)
        Text(
            text = stringResource( R.string.taxes),
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.End
        )
        Text(
            text = stringResource( R.string.last),
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.error,
            textAlign = TextAlign.Right,
        )
        if (!room.isPrepaymentNeeded) {
            NoPrepaymentRow(iconModifier)
        }
    }
}

@Composable
private fun PriceRow(room: Room) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(Spacing.Tiny)
    ) {
        if (room.discountedCost < room.originalCost) {
            Text(
                text = "€${room.originalCost}",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.error,
                textDecoration = TextDecoration.LineThrough,
                textAlign = TextAlign.End
            )
        }
        Text(
            text = "€${room.discountedCost}",
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.onSurface,
            textAlign = TextAlign.End
        )
    }
}

@Composable
private fun NoPrepaymentRow(iconModifier: Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(Spacing.Small)
    ) {
        Icon(
            imageVector = Icons.Default.Check,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSurface,
            modifier = iconModifier
        )
        Text(
            text = stringResource(R.string.no_prepayment_needed),
            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
            color = MaterialTheme.colorScheme.onSurface,
            textAlign = TextAlign.End
        )
    }
}
