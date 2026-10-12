package com.masterlab.grupo13.navigation

//Sealed class se usa para definir las rutas seguras en la navegacion
sealed class Screen(val route: String){

    //Data object es un singleton seguro de tipos
    data object Home : Screen("home_page")
    data object Profile : Screen("profile_page")
    data object Settings : Screen("settings_page")
}