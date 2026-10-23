package com.masterlab.grupo13.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.masterlab.grupo13.viewmodel.UsuarioViewModel
import androidx.compose.runtime.getValue


@Composable
fun ResumenScreen(viewModel: UsuarioViewModel){

    val estado by viewModel.estado.collectAsState()

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Resumen del Registro", style = MaterialTheme.typography.headlineMedium)
        Text("Nombre: ${estado.nombre}")
        Text("Correo: ${estado.correo}")
        Text("Direccion: ${estado.direccion}")
        // La clave se muestra como asteriscos, una por cada carácter
        Text("Contraseña: ${"*".repeat(estado.clave.length)}")
        Text("Terminos: ${if (estado.aceptaTerminos) "Aceptados" else "No aceptados"}")
    }
}