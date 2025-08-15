package com.anjie.joyshotelbookingapp.ui.theme.screens


import androidx.benchmark.traceprocessor.Row
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil3.compose.AsyncImage
import com.anjie.joyshotelbookingapp.R
import com.anjie.joyshotelbookingapp.ui.data.sampleHotels
import com.anjie.joyshotelbookingapp.ui.data.Hotel
import org.jetbrains.annotations.Async
import java.util.Locale


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
                    Image(painter = painterResource(R.drawable.serena), contentDescription = "", contentScale = ContentScale.Fit)
                    Text("Packing Available")
                    Text("Wifi Available")
                    Text("Pools Available")
                }
            }
        }
    }
}




@Composable
fun Homescreen() {
    // states
    val searchInput: MutableState<String> = remember {
        mutableStateOf("")
    }
    val hotel: List<Hotel> = emptyList()


Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp, horizontal = 16.dp)
    ) {

    }

    AsyncImage(
        model = R.drawable.serena,
        contentDescription = "Profile image of user - super mario",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(48.dp)
            .clip(CircleShape)
            .border(
                brush = Brush.horizontalGradient(
                    colors = listOf(Color.Red, Color.Blue, Color.Green),
                    startX = 0.0f,
                    endX = 500.0f,
                    tileMode = TileMode.Repeated
                ),
                width = 4.dp,
                shape = RoundedCornerShape(32.dp)
            )
    )


    Text(
        text = "Welcome to our humble aboard?",
        fontSize = 24.sp,
        lineHeight = 24.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(vertical = 4.dp, horizontal=16.dp))

                // input/ search section
   TextField(
        value = searchInput.value,
       onValueChange = {},
        placeholder = { Text(text = "Get more ") },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            errorContainerColor = Color.Red,
            focusedIndicatorColor = Color.Red,
            unfocusedIndicatorColor = Color.LightGray,
            focusedLeadingIconColor =  Color.Red,
            unfocusedLeadingIconColor = Color.LightGray,
            focusedTrailingIconColor = Color.Red,
            unfocusedTrailingIconColor = Color.LightGray

        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp, horizontal = 8.dp)
            .clip(RoundedCornerShape(24.dp)),
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "search icon",
            )

        })





        }



