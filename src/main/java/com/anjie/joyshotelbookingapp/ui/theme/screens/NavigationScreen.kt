package com.anjie.joyshotelbookingapp.ui.theme.screens

import android.window.SplashScreen
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun BookApp() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "Splash"){
        composable("splash"){ SplashScreen(navController) }
        composable("login"){LoginScreen(navController)}
        composable("register"){ RegisterationScreen(navController) }
        composable("home"){ HomeScreen(navController) }
        composable("detail/{hotelId}"){
            val hotelId =
                it.arguments?.getString("hotelId")?.toInt()?:0
            HotelDetailScreen(hotelId,navController)
        }
        composable("booking/{hotelId}")
        {
            val hotelId =
                it.arguments?.getString("hotelId")?.toInt()?:0
            BookingScreen(hotelId,navController)
        }
        composable ("confirmation"){  ConfirmationScreen()}

    }

}

@Composable
fun RegistrationScreen(navController: NavHostController) {

}
