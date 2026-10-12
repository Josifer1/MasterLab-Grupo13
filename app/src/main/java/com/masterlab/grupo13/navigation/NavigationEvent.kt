package com.masterlab.grupo13.navigation

//Distintos tipos de eventos de navegacion
sealed class NavigationEvent{

    //Navegar a un destino especifico
    data class NavigateTo(
        val route: Screen,
        val popUpToRoute: Screen? = null, // pantalla hasta la cual se hace 'pop'
        val inclusive: Boolean = false, //si true, tambien se elimina esa pantalla
        val singleton: Boolean = false //evita copias repetidas del mismo destino
    ): NavigationEvent()

    //volver a la pantalla anterior
    object PopBackStack : NavigationEvent()

    //Navegar hacia arriba en la jerarquia
    object NavigateUp: NavigationEvent()
}