package com.vsyninfo.movie.Screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController

@Composable
fun DetailScreen(navController: NavController, string: String?) {
     Scaffold(modifier = Modifier
         .fillMaxWidth()
         .fillMaxHeight(),
     topBar = { TopAppBar(backgroundColor = Color.Blue) {
     Text(text = "Details Screen")
     }}) {
         Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
             Text(text ="Details Screen"+string,
                 fontFamily = FontFamily.SansSerif,
                 fontWeight = FontWeight.ExtraBold)
         }

     }
}