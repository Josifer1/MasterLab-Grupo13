package com.masterlab.grupo13.model

//Guarda los posibles mensjaes de error de cada campo (Null = sin error)
data class UsuarioErrores(
    val nombre: String?=null,
    val correo: String?=null,
    val clave: String?=null,
    val direccion: String?=null
)