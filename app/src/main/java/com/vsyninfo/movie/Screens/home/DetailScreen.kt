package com.vsyninfo.movie.Screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.vsyninfo.movie.R
import com.vsyninfo.movie.model.getMovie

@Composable
fun DetailScreen(navController: NavController, movieTitle: String?) {
    val new = getMovie().filter { it.Title == movieTitle }
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
     Text(text = movieTitle!!, style = MaterialTheme.typography.h6, color = Color.White)
     }}) {
         Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
             movieCard(new.first())
               LazyRow(modifier = Modifier.padding(10.dp)){
                   items(new.first().Images){ image ->
                       AsyncImage(

                           model = ImageRequest.Builder(LocalContext.current)
                               .data(image)
                               .crossfade(true)
                               .build(),
                           placeholder = painterResource(R.drawable.ic_launcher_background),
                           contentDescription = "",
                           contentScale = ContentScale.Crop,
                           modifier = Modifier.clip(RoundedCornerShape(CornerSize(5.dp))).height(150.dp).width(200.dp)
                       )
                   }
               }

         }

     }
}