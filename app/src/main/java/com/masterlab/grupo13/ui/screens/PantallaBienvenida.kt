package com.masterlab.grupo13.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.masterlab.grupo13.R
import com.masterlab.grupo13.ui.theme.MasterLab_Grupo13Theme


//La pantalla no conoce el controlador, avisa con una funcion al presionar el btn
@Composable
fun PantallaBienvenida(alPresionarComenzar: () -> Unit){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo de Master Martitni",
            modifier = Modifier.height(160.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Recetas, Videos y Cursos para tu negocio",
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(32.dp))

        //Boton grande para que sea facil de presionar
        Button(
            onClick = alPresionarComenzar,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        ) {
            Text("Comenzar")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun VistaPreviaBienvenida(){

    MasterLab_Grupo13Theme {
        PantallaBienvenida(alPresionarComenzar = {})
    }

}