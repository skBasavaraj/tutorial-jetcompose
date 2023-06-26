package com.vsyninfo.movie.Screens.home

import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.vsyninfo.movie.navigation.MovieNavigation
import com.vsyninfo.movie.navigation.MovieScreens
import com.vsyninfo.movie.ui.theme.MovieTheme
import com.vsyninfo.movie.ui.theme.Shapes

@Composable
fun HomeScreen(navController: NavController){
    Scaffold(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(), topBar = {
            TopAppBar(
                backgroundColor = Color.Blue
            ) {
                Text(
                    "Movie App",
                    style = TextStyle(
                        color = Color.White,
                    )
                )
            }
        }, backgroundColor = Color.White
    ) {
        MainContent( navController)
    }
}
@Composable
fun MainContent(navController: NavController,
    movieList: List<String> = listOf(
        "A",
        "B",
        "C",
        "D",
        "E",
        "F",
        "G",
        "H",
        "I",
        "k",
        "l",
        "m",
        "n",
        "o",
        "p",
        "q",
        "r",
        "s",
        "t",
        "u",
        "v",
        "1",
        "2",
        "3",
        "4",
        "5",
        "6",
        "7",
        "8",
        "9"
    )
) {
    Column(modifier = Modifier.padding()) {
        LazyColumn {
            items(items = movieList) {
                movieCard(it) {movie ->
                    navController.navigate(MovieScreens.DetailsScreen.name+"/$movie",)
                    Log.d("TAG", "Movie $it")
                }
            }
        }
    }
}

@Composable
fun movieCard(
    s: String, onITemCil
    : (String) -> Unit = {}
) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .height(150.dp)
        .padding(10.dp)
        .clickable {
            onITemCil(s)
        }, shape = RoundedCornerShape(
        corner = CornerSize(10.dp),
    ), elevation = 5.dp) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,

        ) {
            Surface(
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .width(100.dp)
                    .height(90.dp), shape = RoundedCornerShape(corner = CornerSize(10)),
                elevation = 10.dp
            ) {

                 Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "", )

            }
            Text(
                text = "Hello $s!",
                fontSize = TextUnit.Unspecified,
                fontWeight = FontWeight.ExtraBold
            )


        }

    }

}
