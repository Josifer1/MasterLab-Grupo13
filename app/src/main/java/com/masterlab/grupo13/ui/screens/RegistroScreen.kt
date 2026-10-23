package com.masterlab.grupo13.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.masterlab.grupo13.viewmodel.UsuarioViewModel
import androidx.compose.runtime.getValue
import com.masterlab.grupo13.navigation.Pantalla

@Composable
fun RegistroScreen(
    controladorNavegacion: NavController,
    viewModel: UsuarioViewModel
){

    //La pantalla se redibuja sola al cambiar(Estado)
    val estado by viewModel.estado.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Registro de usuario",
            style = MaterialTheme.typography.headlineMedium
        )

        //campo nombre
        OutlinedTextField(
            value = estado.nombre,
            onValueChange = viewModel::alCambiarNombre,
            label = {Text("Nombre")},
            isError = estado.errores.nombre != null,
            supportingText = {
                estado.errores.nombre?.let {
                    Text(it, color = MaterialTheme.colorScheme.error)
                }
            },
            modifier = Modifier.fillMaxWidth()
        )

        //campo correo
        OutlinedTextField(
            value = estado.correo,
            onValueChange = viewModel::alCambiarCorreo,
            label = {Text("Correo electronico")},
            isError = estado.errores.correo != null,
            supportingText = {
                estado.errores.correo?.let{
                    Text(it, color = MaterialTheme.colorScheme.error)
                }
            },
            modifier = Modifier.fillMaxWidth()
        )

        //campo clave (oculta los caracteres con puntos)
        OutlinedTextField(
            value = estado.clave,
            onValueChange = viewModel::alCambiarClave,
            label = {Text("Contraseña")},
            visualTransformation = PasswordVisualTransformation(),
            isError = estado.errores.clave != null,
            supportingText = {
                estado.errores.clave?.let{
                    Text(it, color = MaterialTheme.colorScheme.error)
                }
            },
            modifier = Modifier.fillMaxWidth()
        )

        //campo direccion
        OutlinedTextField(
            value = estado.direccion,
            onValueChange = viewModel::alCambiarDireccion,
            label = {Text("Direccion")},
            isError = estado.errores.direccion != null,
            supportingText = {
                estado.errores.direccion?.let{
                    Text(it, color = MaterialTheme.colorScheme.error)
                }
            },
            modifier = Modifier.fillMaxWidth()
        )

        //CheckBox de Aceptar Terminos
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = estado.aceptaTerminos,
                onCheckedChange = viewModel::alCambiarAceptaTerminos
            )
            Spacer(Modifier.width(8.dp))
            Text("Acepto los terminos y condiciones")
        }

        //Boton si el formulario es valido navega al resumen
        Button(
            onClick = {
                if (viewModel.validarFormulario()){
                    controladorNavegacion.navigate(Pantalla.Resumen.ruta)
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Registrar")
        }
    }
}