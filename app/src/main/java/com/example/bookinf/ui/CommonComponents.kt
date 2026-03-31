package com.example.bookinf.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.bookinf.ui.theme.customColors

@Composable
fun MessageBlock(text: String, modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
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
fun QualityRatingBlock(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
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
fun PropertiesCountRow(count: Int, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
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
fun Header(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        style = MaterialTheme.typography.headlineMedium,
        modifier = modifier.padding(16.dp)
    )
}

@Composable
fun Banner(text: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(MaterialTheme.colorScheme.primaryContainer),
        contentAlignment = Alignment.Center
    ) {
        Text(text = text, color = MaterialTheme.colorScheme.onPrimaryContainer)
    }
}

@Composable
fun SearchBar(text: String, modifier: Modifier = Modifier) {
    TextField(
        value = text,
        onValueChange = {},
        modifier = modifier.fillMaxWidth().padding(8.dp),
        placeholder = { Text("Search...") }
    )
}

@Composable
fun FilterBar(text: String, modifier: Modifier = Modifier) {
    Row(modifier = modifier.fillMaxWidth().padding(8.dp)) {
        Text("Filters: $text", style = MaterialTheme.typography.labelLarge)
    }
}

@Composable
fun AppButton(text: String, modifier: Modifier = Modifier, onClick: () -> Unit = {}) {
    Button(onClick = onClick, modifier = modifier) {
        Text(text = text)
    }
}

@Composable
fun TagLabel(text: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
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
fun RatingBox(score: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(25.dp, 30.dp)
            .background(
                color = MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(topStart = 6.dp, topEnd = 6.dp, bottomEnd = 6.dp, bottomStart = 0.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = score,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onPrimary,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun DotSeparator(
    modifier: Modifier = Modifier,
    size: Dp = 4.dp,
    color: Color = MaterialTheme.colorScheme.onSurfaceVariant
) {
    Box(
        modifier = modifier
            .size(size)
            .background(color, shape = RoundedCornerShape(50))
    )
}
