package com.anjie.joyshotelbookingapp.ui.theme.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController



@SuppressLint("RememberReturnType")
@Composable
fun BookingScreen(hotelId: Int,navController: NavController) {
    var guestName by remember { mutableStateOf("") }
    var nights by remember { mutableStateOf("") }
    var modeofpayment by remember { mutableStateOf("") }
    var gender by remember {mutableStateOf("")}
    var identitycode by remember { mutableStateOf("") }
    var checkinDate by remember {mutableStateOf("")}
    var checkoutDate by remember{mutableStateOf("")}
    var roomsneeded by remember { mutableStateOf("") }
    val context = LocalContext.current


    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)){
        Text("Booking for Hotel ID$hotelId " , fontSize = 20.sp
        )
        OutlinedTextField(value = guestName,
            onValueChange = {guestName=it},
            label = {Text("Your Name")})
        OutlinedTextField(
            value = nights,
            onValueChange = {nights = it},
            label = {Text("Nights")},
        )
        OutlinedTextField(value = modeofpayment,
            onValueChange = {modeofpayment=it},
            label = {Text("Mode of payment")}
        )
        OutlinedTextField(value = gender,
            onValueChange = {gender=it},
            label = {Text("Gender")}
        )
        OutlinedTextField(value = identitycode,
            onValueChange = {identitycode=it},
            label = {Text("Identity Code")}
        )
        OutlinedTextField(value = checkinDate,
            onValueChange = {checkinDate=it},
            label = {Text("checkin date")}
        )
        OutlinedTextField(value = checkoutDate,
            onValueChange = {checkoutDate},
            label = {Text("checkout date")}
        )
        OutlinedTextField(value = roomsneeded,
            onValueChange = {roomsneeded=it},
            label = {Text("Rooms Needed")}
        )

        Spacer(Modifier.height(16.dp))
        Button(onClick = {navController.navigate("confirmation")}) {
            Text("Confirm Booking")
        }
    }

}

@Composable
fun Bookingscreen () {
    val bookings= listOf(

        Triple("john Doe","Room: 101","2025-08-12"),
        Triple("jane Smith","Room:102","2025-05-15")
    )
    Column ( modifier=Modifier.padding(16.dp)) {
        Text("Bookings", style = MaterialTheme,typography.headlineSmall)
        bookings.forEach {(name, room, date)->
            Text(".$name booked  $room on $date")
        }
    }

}

fun Text(s: String, style: MaterialTheme, headlineSmall: TextStyle) {
    TODO("Not yet implemented")
}




