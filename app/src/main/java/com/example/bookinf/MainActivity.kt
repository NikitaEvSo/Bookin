package com.example.bookinf

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bookinf.data.GreenTag
import com.example.bookinf.data.Room
import com.example.bookinf.ui.theme.BookinfTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val rooms = listOf(
                Room(
                    Title = "NH Barcelona Eixample",
                    Score = 7.9f,
                    Reviews = 2023,
                    Distance = 1300,
                    stars = 3,
                    DiscountedCost = 200,
                    Cost = 281,
                    tags = listOf(GreenTag("Limited-time Deal")),
                    PrePayment = false,
                ),
                Room(
                    Title = "Hotel Conqueridor",
                    Score = 7.9f,
                    Reviews = 4303,
                    Distance = 450,
                    stars = 4,
                    DiscountedCost = 99,
                    Cost = 111,
                    PrePayment = true,
                ),
                Room(
                    Title = "Lindala",
                    Score = 7.9f,
                    Reviews = 1720,
                    Distance = 450,
                    stars = 4,
                    DiscountedCost = 70,
                    Cost = 281,
                    PrePayment = true,
                )
            )
            BookinfTheme {
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
fun ContentScreen(rooms: List<Room>, modifier: Modifier = Modifier) {
    // Frame 181
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
            .verticalScroll(rememberScrollState())
            .padding(vertical = 13.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(13.dp)
    ) {
        // message
        MessageBlock(
            text = "Commission paid on bookings and other factors may affect property rankings. Learn about these ranking parameteters and how to select and modify them. Find out more"
        )

        // Frame 178
        Row(
            modifier = Modifier
                .width(393.dp)
                .height(23.dp)
                .padding(horizontal = 17.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "748 properties",
                fontFamily = FontFamily.SansSerif,
                fontSize = 14.sp,
                lineHeight = 23.sp,
                color = Color.Black
            )
        }

        // Frame 179
        Column(
            modifier = Modifier.width(393.dp),
            verticalArrangement = Arrangement.spacedBy(13.dp)
        ) {
            rooms.forEach { room ->
                RoomCard(room)
            }
        }

        // Quality rating message
        QualityRatingBlock()
    }
}

@Composable
fun MessageBlock(text: String) {
    Box(
        modifier = Modifier
            .width(360.dp)
            .height(141.dp)
            .background(Color.White, shape = RoundedCornerShape(6.dp))
            .padding(17.dp)
    ) {
        Text(
            text = text,
            fontFamily = FontFamily.SansSerif,
            fontSize = 14.sp,
            lineHeight = 23.sp,
            color = Color.Black,
            modifier = Modifier.width(256.dp).align(Alignment.CenterStart)
        )
    }
}

@Composable
fun QualityRatingBlock() {
    Box(
        modifier = Modifier
            .width(360.dp)
            .height(141.dp)
            .background(Color.White, shape = RoundedCornerShape(6.dp))
            .padding(16.dp)
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            Box(
                modifier = Modifier
                    .size(19.dp)
                    .background(Color(0xFFFCB800), shape = RoundedCornerShape(3.dp)),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .background(Color.White, shape = RoundedCornerShape(50))
                )
            }

            Column(verticalArrangement = Arrangement.spacedBy(19.dp)) {
                Text(
                    text = "Properties with these icons have been awarded Booking.com´s quality rating for homes",
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 14.sp,
                    lineHeight = 21.sp,
                    color = Color.Black,
                    modifier = Modifier.width(256.dp)
                )
                Text(
                    text = "Learn more",
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    lineHeight = 23.sp,
                    color = Color(0xFF248DDC)
                )
            }
        }
    }
}

@Composable
fun RoomCard(room: Room) {
    // Frame 106
    Column(
        modifier = Modifier.defaultMinSize(minHeight = 321.dp)
            .width(393.dp)
            .height(325.dp)
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 17.dp, end = 17.dp, bottom = 13.dp)
                .weight(1f),
            horizontalArrangement = Arrangement.spacedBy(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // image
            Box(
                modifier = Modifier
                    .width(118.dp)
                    .height(306.dp)
                    .background(color = Color(0xFFEBEBEB),
                        shape = RoundedCornerShape(6.dp))
            )

            // Frame 105
            Column(
                modifier = Modifier
                    .width(227.dp)
                    .height(321.dp),
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                // Frame 102
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    // Group 20
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = room.Title,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            fontStyle = FontStyle.Normal,
                            textAlign = TextAlign.Start,
                            lineHeight = 23.sp,
                            color = Color.Black,
                            fontFamily = FontFamily.SansSerif
                        )
                        Icon(
                            imageVector = Icons.Default.FavoriteBorder,
                            contentDescription = "Favorite",
                            modifier = Modifier.size(18.dp),
                            tint = Color(0xFF424141)
                        )
                    }

                    // Frame 94
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(3.dp)
                    ) {
                        repeat(room.stars) {
                            Icon(
                                imageVector = Icons.Default.Star,
                                contentDescription = null,
                                tint = Color(0xFFF9BA2B),
                                modifier = Modifier.size(17.dp)
                            )
                        }
                        Icon(
                            imageVector = Icons.Default.ThumbUp,
                            contentDescription = null,
                            tint = Color(0xFFF9BA2B),
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

                    // Frame 96
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(9.dp)
                    ) {
                        RatingBox(score = room.Score.toString())
                        Text(
                            text = room.TextRate(),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            fontStyle = FontStyle.Normal,
                            textAlign = TextAlign.Start,
                            lineHeight = 23.sp,
                            color = Color.Black,
                            fontFamily = FontFamily.SansSerif
                        )
                        Box(
                            modifier = Modifier
                                .size(4.dp)
                                .background(Color(0xFF434343), shape = RoundedCornerShape(50))
                        )
                        Text(
                            text = "${room.Reviews} reviews",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Medium,
                            fontStyle = FontStyle.Normal,
                            textAlign = TextAlign.Start,
                            lineHeight = 23.sp,
                            color = Color(0xFF434343),
                            fontFamily = FontFamily.SansSerif
                        )
                    }

                    // Frame 100
                    Column(verticalArrangement = Arrangement.spacedBy(0.dp)) {
                        // Frame 97
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(5.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.LocationOn,
                                contentDescription = null,
                                modifier = Modifier.size(14.dp),
                                tint = Color.Black
                            )
                            Text(
                                text = "Example",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Normal,
                                fontStyle = FontStyle.Normal,
                                textAlign = TextAlign.Start,
                                lineHeight = 23.sp,
                                color = Color.Black,
                                fontFamily = FontFamily.SansSerif
                            )
                            Box(
                                modifier = Modifier
                                    .size(3.dp)
                                    .background(Color.Black, shape = RoundedCornerShape(50))
                            )
                            Text(
                                text = "${(room.Distance / 1000.0)} km from centre",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Normal,
                                fontStyle = FontStyle.Normal,
                                textAlign = TextAlign.Start,
                                lineHeight = 23.sp,
                                color = Color.Black,
                                fontFamily = FontFamily.SansSerif
                            )
                        }
                        // Group 21
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(5.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.CheckCircle,
                                contentDescription = null,
                                modifier = Modifier.size(14.dp),
                                tint = Color.Black
                            )
                            Text(
                                text = "Sustainability certification",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Normal,
                                fontStyle = FontStyle.Normal,
                                textAlign = TextAlign.Start,
                                lineHeight = 23.sp,
                                color = Color.Black,
                                fontFamily = FontFamily.SansSerif
                            )
                        }
                    }

                    room.tags.forEach { tag ->
                        // Frame 101
                    Box(
                        modifier = Modifier
                            .width(118.dp)
                            .height(23.dp)
                            .background(color = Color(0xFF1B8947), shape = RoundedCornerShape(4.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                            Text(
                                text = tag.text,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Normal,
                                fontStyle = FontStyle.Normal,
                                textAlign = TextAlign.Center,
                                lineHeight = 23.sp,
                                color = Color.White,
                                fontFamily = FontFamily.SansSerif
                            )
                        }
                    }
                }

                // Frame 104
                Column(
                    modifier = Modifier.width(170.dp),
                    horizontalAlignment = Alignment.End,
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(
                        text = "Hotel room: 2 beds",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Normal,
                        textAlign = TextAlign.End,
                        lineHeight = 23.sp,
                        color = Color.Black,
                        fontFamily = FontFamily.SansSerif
                    )
                    Text(
                        text = "Price for 1 night, 2 adults",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Medium,
                        fontStyle = FontStyle.Normal,
                        textAlign = TextAlign.End,
                        lineHeight = 23.sp,
                        color = Color.Black,
                        fontFamily = FontFamily.SansSerif
                    )
                    // Frame 103
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(3.dp)
                    ) {
                        Text(
                            text = "€${room.Cost}",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium,
                            fontStyle = FontStyle.Normal,
                            textAlign = TextAlign.End,
                            lineHeight = 23.sp,
                            color = Color(0xFFC0060E),
                            textDecoration = TextDecoration.LineThrough,
                            fontFamily = FontFamily.SansSerif
                        )
                        Text(
                            text = "€${room.DiscountedCost}",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            fontStyle = FontStyle.Normal,
                            textAlign = TextAlign.End,
                            lineHeight = 23.sp,
                            color = Color.Black,
                            fontFamily = FontFamily.SansSerif
                        )
                    }
                    Text(
                        text = "Includes taxes and charges",
                        fontSize = 13.sp,
                        softWrap = false,
                        fontWeight = FontWeight.Medium,
                        fontStyle = FontStyle.Normal,
                        textAlign = TextAlign.End,
                        lineHeight = 23.sp,
                        color = Color(0xFF767373),
                        fontFamily = FontFamily.SansSerif
                    )
                    Text(
                        text = "Only 1 left at this price on Booking.com",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Medium,
                        fontStyle = FontStyle.Normal,
                        textAlign = TextAlign.Right,
                        lineHeight = 19.sp,
                        color = Color(0xFFC0060E),
                        fontFamily = FontFamily.SansSerif,
                        modifier = Modifier.width(158.dp)
                    )
                    if (room.PrePayment) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Check,
                                contentDescription = null,
                                tint = Color.Black,
                                modifier = Modifier.size(13.dp)
                            )
                            Text(
                                text = "No prepayment needed",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                fontStyle = FontStyle.Normal,
                                textAlign = TextAlign.End,
                                lineHeight = 23.sp,
                                color = Color.Black,
                                fontFamily = FontFamily.SansSerif
                            )
                        }
                    }
                }
            }
        }
        HorizontalDivider(thickness = 1.dp, color = Color(0xFFE3E3E3))
    }
}

@Composable
fun RatingBox(score: String) {
    Box(
        modifier = Modifier
            .size(30.dp, 32.dp)
            .background(
                color = Color(0xFF003C94),
                shape = RoundedCornerShape(topStart = 6.dp, topEnd = 6.dp, bottomEnd = 6.dp, bottomStart = 0.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = score,
            fontSize = 15.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center,
            lineHeight = 23.sp,
            color = Color.White,
            fontFamily = FontFamily.SansSerif
        )
    }
}
