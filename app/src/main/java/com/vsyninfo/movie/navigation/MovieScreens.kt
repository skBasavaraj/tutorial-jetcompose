package com.vsyninfo.movie.navigation

enum class MovieScreens {
    HomeScreen,
    DetailsScreen;
    companion object {
      fun fromRoutes(routes: String?): MovieScreens
      = when (routes!!.substringBefore("/")) {
        HomeScreen.name -> HomeScreen
          DetailsScreen.name -> DetailsScreen
          null -> HomeScreen
          else -> throw IllegalArgumentException("Routes $routes is not recognized")
      }
    }
}