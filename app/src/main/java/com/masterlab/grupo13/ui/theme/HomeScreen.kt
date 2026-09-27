package com.masterlab.grupo13.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.masterlab.grupo13.R

// Pantalla principal (Home) de la app
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(){
    //Se creea una variable y se le asigna con by el string que escribe el usuario
    var nombre by remember { mutableStateOf("") }
    Scaffold(
        // Barra superior con el título de la app
        topBar = {
            TopAppBar(title = {
                Text("Mi App Kotlin") })
        }
    ) { innerPadding ->
// Contenedor principal de la pantalla
        Column(
            modifier = Modifier
                // respeta el espacio que deja la TopAppBar
                .padding(innerPadding)
                .fillMaxSize()
                .padding(16.dp),
            // espaciado uniforme entre elementos
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            //Saludo Donde se utiliza la variable
            Text(
                text = if (nombre.isBlank()) "Hola!!!!!!" else "Holasssss $nombre!",
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.onBackground
            )
            //Campo de texto donde escribe el usuario
            OutlinedTextField(
                value = nombre,
                onValueChange = {nombre=it},
                label = {Text("INGRESA TU NOMBRE")},
                modifier = Modifier.fillMaxWidth()
            )

            Text(text = "¡Bienvenido!")
            Button(onClick = {/*accion futura*/}) {
                Text("Presioname")
            }
            // Imagen del logo de la app
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "logo App",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                contentScale = ContentScale.Fit
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}
