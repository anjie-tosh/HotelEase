package com.anjie.joyshotelbookingapp.ui.theme.screens

import ads_mobile_sdk.h5
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RoomsScreen() {
    val rooms=listOf(
        Triple("101","Single","Occupied"),
        Triple("102","Double","Available")
    )
    Column (modifier= Modifier.padding(16.dp)){
        Text("Rooms",style= MaterialTheme.typography.headlineSmall)
        rooms. forEach{(number, type, status)->
            Text("Room $number - $type -$status")
        }
    }
}