package com.masterlab.grupo13.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.masterlab.grupo13.viowmodel.MainViewModel
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.unit.dp
import com.masterlab.grupo13.navigation.Screen

@Composable
fun SettingsScreen(
    navController: NavController,
    viewModel: MainViewModel
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Pantalla de Configuracion (Settings)")
        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = {viewModel.navigateTo(Screen.Home)}) {
            Text("Volver al Inicio")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {viewModel.navigateTo(Screen.Profile)}) {
            Text("Ir a Perfil")
        }
    }
}