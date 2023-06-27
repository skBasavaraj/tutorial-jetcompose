package com.vsyninfo.movie.Screens.home

import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.vsyninfo.movie.R
import com.vsyninfo.movie.model.Movie
import com.vsyninfo.movie.model.getMovie
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
    movieList: List<Movie> =  getMovie()
) {
    Column(modifier = Modifier.padding()) {
        LazyColumn {
            items(items = movieList) {
                movieCard(it) {movie ->
                    navController.navigate(MovieScreens.DetailsScreen.name+"/${movie.Title}",)
                    Log.d("TAG", "Movie $it")
                }
            }
        }
    }
}

@Composable
fun movieCard(
    s: Movie, onITemCil
    : (Movie) -> Unit = {}
) {
    var expanded by remember{
        mutableStateOf(false)
     }
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
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data( s.Images[0])
                        .crossfade(true)
                        .build(),
                    placeholder = painterResource(R.drawable.ic_launcher_background),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.clip(RoundedCornerShape(CornerSize(5.dp)))
                )
               //  Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "", )

            }
            Column(verticalArrangement =  Arrangement.Center) {
                Text(
                    text = "${s.Title}",
                    style =MaterialTheme.typography.h6,
                    fontWeight = FontWeight.W400,
                    fontFamily = FontFamily.SansSerif
                )
                Text(
                    text = "${s.Director}",
                    style =MaterialTheme.typography.caption,
                    fontWeight = FontWeight.W300,
                    fontFamily = FontFamily.SansSerif
                )
                Text(
                    text = "${s.Released}",
                    style =MaterialTheme.typography.caption,
                    fontWeight = FontWeight.W300,
                    fontFamily = FontFamily.SansSerif
                )
                AnimatedVisibility(visible =expanded) {
                    Column() {
                        Text(
                            text = "${s.imdbRating}",
                            style =MaterialTheme.typography.caption,
                            fontWeight = FontWeight.W200,
                            fontFamily = FontFamily.SansSerif
                        )
                        Text(
                            text = "${s.imdbVotes}",
                            style =MaterialTheme.typography.caption,
                            fontWeight = FontWeight.W200,
                            fontFamily = FontFamily.SansSerif
                        )
                    }
                }
                Icon(imageVector =if(expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                contentDescription = "",
                modifier = Modifier
                    .padding(top = 5.dp)
                    .clickable {
                        expanded = !expanded
                    })
            }



        }

    }

}
