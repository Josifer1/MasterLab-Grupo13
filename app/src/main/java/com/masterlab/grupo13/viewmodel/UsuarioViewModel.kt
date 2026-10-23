package com.masterlab.grupo13.viewmodel

import androidx.lifecycle.ViewModel
import com.masterlab.grupo13.model.UsuarioErrores
import com.masterlab.grupo13.model.UsuarioUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class UsuarioViewModel : ViewModel(){

    //Estado ViewModel(Solo puede modificar el viewmodel)
    private val _estado = MutableStateFlow(UsuarioUiState())

    //Estado de la pantalla(solo lectura)
    val estado: StateFlow<UsuarioUiState> = _estado

    //Actualiza el nombre y borra su error
    fun alCambiarNombre(valor: String){
        _estado.update { it.copy(nombre = valor, errores = it.errores.copy(nombre = null)) }
    }

    //Actualiza el correo y borra su error
    fun alCambiarCorreo(valor: String){
        _estado.update { it.copy(correo = valor, errores = it.errores.copy(correo = null)) }
    }

    fun alCambiarClave(valor: String){
        _estado.update { it.copy(clave = valor, errores = it.errores.copy(clave = null)) }
    }

    fun alCambiarDireccion(valor: String){
        _estado.update { it.copy(direccion = valor, errores = it.errores.copy(direccion = null)) }
    }

    fun alCambiarAceptaTerminos(valor: Boolean){
        _estado.update { it.copy(aceptaTerminos = valor) }
    }

    //Formulario, se encarga de actualizar los errores y validasitodo esta correcto
    fun validarFormulario(): Boolean{
        val estadoActual = _estado.value

        val errores = UsuarioErrores(
            nombre = if (estadoActual.nombre.isBlank()) "Campo Obligatorio" else null,
            correo = if (!estadoActual.correo.contains("@")) "Correo Invalido" else null,
            clave = if (estadoActual.clave.length<6) "Debe tener al menos 6 caracteres" else null,
            direccion = if (estadoActual.direccion.isBlank()) "Campo Obligatorio" else null
        )

        val hayErrores = listOfNotNull(
            errores.nombre,
            errores.correo,
            errores.clave,
            errores.direccion
        ).isNotEmpty()
        _estado.update { it.copy(errores = errores) }

        return !hayErrores
    }
}









