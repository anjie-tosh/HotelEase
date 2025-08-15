package com.anjie.joyshotelbookingapp.ui.theme.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun ConfirmationScreen() {
    Box (
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text("Booking Confirmed!", fontSize = 24.sp,color = Color.Cyan)
    }
}