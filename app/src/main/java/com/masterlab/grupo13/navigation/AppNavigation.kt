package com.masterlab.grupo13.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.masterlab.grupo13.ui.screens.RegistroScreen
import com.masterlab.grupo13.ui.screens.ResumenScreen
import com.masterlab.grupo13.viewmodel.UsuarioViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.masterlab.grupo13.ui.screens.PantallaBienvenida
import com.masterlab.grupo13.ui.screens.PantallaInicio


@Composable
fun AppNavigation(){

    //un solo ViewModel compartido entre registro y resumen
    val viewModelUsuario: UsuarioViewModel = viewModel()
    val controladorNavegacion = rememberNavController()

    NavHost(
        navController = controladorNavegacion,
        startDestination = Pantalla.Bienvenida.ruta
    ){
        composable(Pantalla.Bienvenida.ruta){
            PantallaBienvenida(
                alPresionarComenzar = {
                    controladorNavegacion.navigate(Pantalla.Registro.ruta)
                }
            )
        }
        composable(Pantalla.Registro.ruta){
            RegistroScreen(controladorNavegacion, viewModelUsuario)
        }
        composable(Pantalla.Resumen.ruta){
            ResumenScreen(
                viewModelUsuario,
                alcontiuar = {
                    controladorNavegacion.navigate(Pantalla.Inicio.ruta) {
                        // Borra las pantallas anteriores: al volver atrás se sale de la app
                        popUpTo(Pantalla.Bienvenida.ruta) { inclusive = true }
                    }
                }
            )
        }
        composable(Pantalla.Inicio.ruta) {
            PantallaInicio()
        }

    }
}