package com.masterlab.grupo13.navigation

//Clase sellada: todas las rutas de al app quedan en un solo lugar
sealed class Pantalla(val ruta: String){
    data object Bienvenida : Pantalla("bienvenida")
    data object Registro: Pantalla("registro")
    data object Resumen : Pantalla("resumen")

    data object Inicio : Pantalla("inicio")
}