package com.example.bookinf

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bookinf.data.Room
import com.example.bookinf.ui.theme.BookinfTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val testRoom: Room = Room(
                Title = "ROOM N1",
                Score = 7.8f,
                Reviews = 2004,
                Distance = 2104,
                stars = 3,
                DiscountedCost = 999,
                Cost = 999,
                PrePayment = true,
            )
            BookinfTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ContentScreen(
                        room = testRoom,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
fun emptyfun(){
    return
}
@Composable
fun RoomCard(room: Room): Unit {
    Card(modifier = Modifier.fillMaxWidth(0.9f)){
        Row{
            Box(modifier = Modifier
                .fillMaxWidth(0.3f)
                .padding(end = 5.dp)
                .background(color= Color(239, 15, 15, 255))){
            }
            VerticalDivider(Modifier.fillMaxHeight(0.3f),thickness = 1.dp)
            Column(
                Modifier.padding(horizontal = 5.dp, vertical = 1.dp)) {
                //title favorite
                Row {
                    Text(text = room.Title)
                    Icon(imageVector = Icons.Default.FavoriteBorder, contentDescription = "4")
                }
                //star rate,tag
                Row{
                    for (i in 0..room.stars){
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = "2"
                            , tint = Color(255, 193, 7, 255)
                        )
                    }
                    Icon(
                        imageVector = Icons.Default.ThumbUp,
                        contentDescription = "2"
                        , tint = Color(255, 193, 7, 255)

                    )
                    TextInBlue(" Genius ")
                }
                //Numeral Score word score Reviews
                Row{
                    TextInBlue(" ${room.Score} ")
                    Text(" ${room.TextRate()} ")
                    Text(" ${room.Reviews} reviews")
                }
                //Distance
                Row {
                    Icon(imageVector = Icons.Default.LocationOn,
                        contentDescription = "location")
                    Text("Example * ${room.Distance} from centre")

                }
                //certification
                Row {
                    Icon(imageVector = Icons.Default.CheckCircle,
                        contentDescription = "Certificate")
                    Text("Sustainability certification")
                }
                Row() {
                    TextInGreen("Limited-time Deal")
                }
                Column(horizontalAlignment = Alignment.End) {
                    Row{
                        Text("HotelRoon:")
                        Text("2 beds")
                    }
                    Row{
                        Text("Price for 1 night, 2 adults")
                    }
                    Row{
                        Text("E${room.DiscountedCost}",
                            color = Color(244, 67, 54, 255),
                            textDecoration = TextDecoration.LineThrough)
                        Text("E${room.Cost}")
                    }
                    Text("Includes taxes and charges", color = Color(0, 0, 0, 102))
                    Text("Only 1 left at this price on", color = Color(244, 67, 54, 255))
                    Text("Booking.com", color = Color(244, 67, 54, 255))
                    if (room.PrePayment){
                        Row{
                            Icon(
                                imageVector = Icons.Default.Check, contentDescription = "2"
                            )
                            Text("No prepayment needed")
                        }
                    }
                }
            }
        }
    }
}
@Composable
fun TextInBlue(text: String){
    Box(
        modifier = Modifier.background(color = Color(63, 81, 181, 255))
    ){
        Text(text = text, color = Color(255, 255, 255, 255))
    }
}
@Composable
fun TextInGreen(text: String){
    Box(
        modifier = Modifier.background(color = Color(76, 175, 80, 255))
    ){
        Text(text = text, color = Color(255, 255, 255, 255))
    }
}
@Composable
fun ContentScreen(room: Room, modifier: Modifier = Modifier) {
    Box(modifier= modifier){
        RoomCard(room)
    }
}
