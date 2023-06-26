package com.vsyninfo.movie.Screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
         Row(horizontalArrangement = Arrangement.Center) {
             Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "",
             modifier = Modifier.clickable {
                 navController.popBackStack()
             })
         }
     Text(text = string!!, style = MaterialTheme.typography.h6, color = Color.White)
     }}) {
         Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
             Text(text ="Details Screen\n"+string,
                 style = MaterialTheme.typography.h2,
                 fontFamily = FontFamily.SansSerif,
                 fontWeight = FontWeight.ExtraBold)
         }

     }
}