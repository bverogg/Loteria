package com.bverog.loteria.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bverog.loteria.R

@Composable
fun MainScreen(navController: NavController){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(32.dp),
        verticalArrangement = Arrangement.Center){
        Text( "Lotería" , fontSize = 32.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            color = Color.DarkGray,
            modifier = Modifier.fillMaxWidth())
        Image(
            painter = painterResource(id = R.drawable.loteria),
            contentDescription = "Carta de Lotería",
            modifier = Modifier.size(400.dp)
        )
        Button(onClick = {
            navController.navigate("cards_screen")
        }, modifier = Modifier.fillMaxWidth()) {
            Text("Iniciar Juego")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen(){
    val navController = rememberNavController()
    MainScreen(navController)
}