package com.anjie.joyshotelbookingapp.ui.theme.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.anjie.joyshotelbookingapp.ui.data.sampleHotels
import com.anjie.joyshotelbookingapp.ui.data.sampleHotels

@Composable
fun HotelDetailScreen(hotelId: Int, navController: NavHostController) {
    val hotel = sampleHotels.find { it.id ==hotelId }?:return
    Column (Modifier.padding(16.dp).fillMaxSize(),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(hotel.name, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text("Location:${hotel.location}")
        Spacer(Modifier.height(16.dp))
        Button(onClick = {navController.navigate("booking/${hotelId}")}) {
            Text("Book Now")
        }
    }
}