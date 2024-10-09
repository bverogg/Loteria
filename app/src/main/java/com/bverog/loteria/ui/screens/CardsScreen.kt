package com.bverog.loteria.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

@SuppressLint("MutableCollectionMutableState")
@Composable
fun CardsScreen(navController: NavController){
    // Lista de las Cartas completas
    val allCards = listOf(
        R.drawable._i1, R.drawable._i2, R.drawable._i3, R.drawable._i4, R.drawable._i5,
        R.drawable._i6, R.drawable._i7, R.drawable._i8, R.drawable._i9, R.drawable._i10,
        R.drawable._i11, R.drawable._i12, R.drawable._i13, R.drawable._i14, R.drawable._i15,
        R.drawable._i16, R.drawable._i17, R.drawable._i18, R.drawable._i19, R.drawable._i20,
        R.drawable._i21, R.drawable._i22, R.drawable._i23, R.drawable._i24, R.drawable._i25,
        R.drawable._i26, R.drawable._i27, R.drawable._i28, R.drawable._i29, R.drawable._i30,
        R.drawable._i31, R.drawable._i32, R.drawable._i33, R.drawable._i34, R.drawable._i35,
        R.drawable._i36, R.drawable._i37, R.drawable._i38, R.drawable._i39, R.drawable._i40,
        R.drawable._i41, R.drawable._i42, R.drawable._i43, R.drawable._i44, R.drawable._i45,
        R.drawable._i46, R.drawable._i47, R.drawable._i48, R.drawable._i49, R.drawable._i50,
        R.drawable._i51, R.drawable._i52, R.drawable._i53, R.drawable._i54
    )
    // Copia mutable de la lista de cartas para ir eliminando las que ya pasaron
    var cards by remember { mutableStateOf(allCards.toMutableList()) }

    // Variable para la carta actual
    var thisCard by remember { mutableStateOf(cards.random()) }

    // función para obtener una carta
    fun newCard() {
        if (cards.isNotEmpty()) {
            // Se obtiene una nueva carta
            thisCard = cards.random()
            // Se borra la carta ya mostrada
            cards.remove(thisCard)
        } else {
            // Cuando se acaban las cartas, vuelve a obtener las cartas completas
            cards = allCards.toMutableList()
            // Se obtiene una nueva carta
            thisCard = cards.random()
        }
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(32.dp),
        verticalArrangement = Arrangement.Center){
        Text( "Lotería" , fontSize = 32.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            color = Color.DarkGray,
            modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(32.dp))
        Image(
            painter = painterResource(id = thisCard),
            contentDescription = "Carta de Lotería",
            modifier = Modifier.size(500.dp)
        )
        Spacer(modifier = Modifier.height(32.dp))
        Button(onClick = {
            // Obtener nueva carta
            newCard()
        }, modifier = Modifier.fillMaxWidth()) {
            Text("Siguiente Carta")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            // Se utiliza popUpTo para regresar a main_screen y limpiar el stack
            navController.navigate("main_screen") {
                // false hace que solo se eliminen las pantallas hasta donde nos vamos a dirigir
                popUpTo("main_screen") { inclusive = false }
            }
        }, modifier = Modifier.fillMaxWidth()) {
            Text("Terminar Juego")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCardsScreen(){
    val navController = rememberNavController()
    CardsScreen(navController)
}

