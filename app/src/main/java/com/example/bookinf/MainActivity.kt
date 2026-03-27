package com.example.bookinf

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.bookinf.data.GreenTag
import com.example.bookinf.data.Room
import com.example.bookinf.ui.theme.BookinfTheme
import com.example.bookinf.ui.theme.customColors

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BookinfTheme {
                val rooms = rememberRooms()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ContentScreen(
                        rooms = rooms,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
private fun rememberRooms(): List<Room> = remember {
    listOf(
        Room(
            title = "NH Barcelona Eixample",
            score = 7.9f,
            reviews = 2023,
            distanceMeters = 1300,
            stars = 3,
            discountedCost = 200,
            originalCost = 281,
            tags = listOf(GreenTag("Limited-time Deal")),
            isPrepaymentNeeded = false,
        ),
        Room(
            title = "Hotel Conqueridor",
            score = 7.9f,
            reviews = 4303,
            distanceMeters = 450,
            stars = 4,
            discountedCost = 99,
            originalCost = 111,
            isPrepaymentNeeded = true,
        ),
        Room(
            title = "Lindala",
            score = 7.9f,
            reviews = 1720,
            distanceMeters = 450,
            stars = 4,
            discountedCost = 70,
            originalCost = 281,
            isPrepaymentNeeded = true,
        )
    )
}

@Composable
fun ContentScreen(rooms: List<Room>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(13.dp)
    ) {
        item { Spacer(Modifier.height(13.dp)) }
        
        item {
            MessageBlock(
                text = "Commission paid on bookings and other factors may affect property rankings. Learn about these ranking parameteters and how to select and modify them. Find out more"
            )
        }

        item {
            PropertiesCountRow(count = 748)
        }

        items(rooms) { room ->
            RoomCard(room)
        }

        item {
            QualityRatingBlock()
        }
        
        item { Spacer(Modifier.height(13.dp)) }
    }
}

@Composable
private fun PropertiesCountRow(count: Int) {
    Row(
        modifier = Modifier
            .width(393.dp)
            .height(23.dp)
            .padding(horizontal = 17.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "$count properties",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}

@Composable
fun MessageBlock(text: String) {
    Surface(
        modifier = Modifier
            .width(360.dp)
            .height(141.dp),
        color = MaterialTheme.colorScheme.surface,
        shape = RoundedCornerShape(6.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Box(modifier = Modifier.padding(17.dp)) {
            Text(
                text = text,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.width(256.dp).align(Alignment.CenterStart)
            )
        }
    }
}

@Composable
fun QualityRatingBlock() {
    Surface(
        modifier = Modifier
            .width(360.dp)
            .height(141.dp),
        color = MaterialTheme.colorScheme.surface,
        shape = RoundedCornerShape(6.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(19.dp)
                    .background(MaterialTheme.colorScheme.secondary, shape = RoundedCornerShape(3.dp)),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .background(MaterialTheme.colorScheme.onSecondary, shape = RoundedCornerShape(50))
                )
            }

            Column(verticalArrangement = Arrangement.spacedBy(19.dp)) {
                Text(
                    text = "Properties with these icons have been awarded Booking.com´s quality rating for homes",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.width(256.dp)
                )
                Text(
                    text = "Learn more",
                    style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.SemiBold),
                    color = MaterialTheme.customColors.socialVk
                )
            }
        }
    }
}

@Composable
fun RoomCard(room: Room) {
    Surface(
        modifier = Modifier
            .width(393.dp),
        color = MaterialTheme.colorScheme.surface
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 17.dp, end = 17.dp, top = 0.dp, bottom = 13.dp),
                horizontalArrangement = Arrangement.spacedBy(14.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Image placeholder
                Box(
                    modifier = Modifier
                        .width(118.dp)
                        .fillMaxHeight()
                        .background(color = MaterialTheme.colorScheme.surfaceVariant, shape = RoundedCornerShape(6.dp))
                )

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .height(308.dp),

                ) {
                    TopInfoSection(room)
                    BottomPriceSection(room)
                }
            }
            HorizontalDivider(thickness = 1.dp, color = MaterialTheme.colorScheme.outline)
        }
    }
}

@Composable
private fun TopInfoSection(room: Room) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = room.title,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
            Icon(
                imageVector = Icons.Default.FavoriteBorder,
                contentDescription = "Favorite",
                modifier = Modifier.size(18.dp),
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(3.dp)
        ) {
            repeat(room.stars) {
                Icon(
                    painter = painterResource(R.drawable.star),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier.size(17.dp)
                )
            }
            Image(
                painter = painterResource(R.drawable.thumb),
                contentDescription = null,
                modifier = Modifier.size(16.dp)
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
            horizontalArrangement = Arrangement.spacedBy(9.dp)
        ) {
            RatingBox(score = room.score.toString())
            Text(
                text = room.ratingText,
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onSurface
            )
            DotSeparator()
            Text(
                text = "${room.reviews} reviews",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        LocationAndCertification(room)

        room.tags.forEach { tag ->
            TagLabel(tag.text)
        }
    }
}

@Composable
private fun LocationAndCertification(room: Room) {
    Column(verticalArrangement = Arrangement.spacedBy(0.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Icon(
                imageVector = Icons.Default.LocationOn,
                contentDescription = null,
                modifier = Modifier.size(14.dp),
                tint = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = "Example",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
            DotSeparator(size = 3.dp, color = MaterialTheme.colorScheme.onSurface)
            Text(
                text = room.formattedDistance,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Icon(
                imageVector = Icons.Default.CheckCircle,
                contentDescription = null,
                modifier = Modifier.size(14.dp),
                tint = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = "Sustainability certification",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}

@Composable
private fun BottomPriceSection(room: Room) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = "Hotel room: 2 beds",
            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
            color = MaterialTheme.colorScheme.onSurface,
            textAlign = TextAlign.End
        )
        Text(
            text = "Price for 1 night, 2 adults",
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onSurface,
            textAlign = TextAlign.End
        )
        PriceRow(room)
        Text(
            text = "Includes taxes and charges",
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.End
        )
        Text(
            text = "Only 1 left at this price on Booking.com",
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.error,
            textAlign = TextAlign.Right,
            modifier = Modifier.width(158.dp)
        )
        if (!room.isPrepaymentNeeded) {
            NoPrepaymentRow()
        }
    }
}

@Composable
private fun PriceRow(room: Room) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(3.dp)
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
private fun NoPrepaymentRow() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Icon(
            imageVector = Icons.Default.Check,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.size(13.dp)
        )
        Text(
            text = "No prepayment needed",
            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
            color = MaterialTheme.colorScheme.onSurface,
            textAlign = TextAlign.End
        )
    }
}

@Composable
fun TagLabel(text: String) {
    Box(
        modifier = Modifier
            .width(118.dp)
            .height(23.dp)
            .background(color = MaterialTheme.colorScheme.tertiary, shape = RoundedCornerShape(4.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onTertiary,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun RatingBox(score: String) {
    Box(
        modifier = Modifier
            .size(30.dp, 32.dp)
            .background(
                color = MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(topStart = 6.dp, topEnd = 6.dp, bottomEnd = 6.dp, bottomStart = 0.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = score,
            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Normal, color = MaterialTheme.colorScheme.onPrimary),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun DotSeparator(size: Dp = 4.dp, color: Color = MaterialTheme.colorScheme.onSurfaceVariant) {
    Box(
        modifier = Modifier
            .size(size)
            .background(color, shape = RoundedCornerShape(50))
    )
}
