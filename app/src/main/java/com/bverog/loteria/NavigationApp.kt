package com.bverog.loteria

import androidx.compose.runtime.Composable
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.bverog.loteria.ui.screens.CardsScreen
import com.bverog.loteria.ui.screens.MainScreen

@Composable
fun NavigationApp(){
    val navController = rememberNavController()
    NavHost(navController= navController, startDestination = "main_screen"){
        composable("main_screen"){
            MainScreen(navController)
        }
        composable("cards_screen"){
            CardsScreen(navController)
        }
    }
}