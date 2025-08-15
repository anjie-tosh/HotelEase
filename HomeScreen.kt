package com.onen.hotelbookingapp.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.onen.hotelbookingapp.R
import com.onen.hotelbookingapp.data.sampleHotels

@Composable
fun HomeScreen(navController: NavHostController) {
    LazyColumn(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
        .padding(16.dp)){
        items(sampleHotels){ hotel ->
            Card (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable{
                        navController.navigate("detail/${hotel.id}")
                    }){
                Column {
                    Text(hotel.name, fontSize = 20.sp)
                    Text(hotel.location)
                    Image(painter = painterResource(R.drawable.serena), contentDescription = "", contentScale = ContentScale.FillBounds)
                    Text("Packing Available")
                    Text("Wifi Available")
                    Text("Pools Available")
                }
            }
        }
    }
}