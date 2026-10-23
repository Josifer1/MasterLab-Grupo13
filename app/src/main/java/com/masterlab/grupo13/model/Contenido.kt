package com.masterlab.grupo13.model

//Tipos de contenido que ofrece Master Martini
enum class CategoriaContenido(val titulo: String){
    RECETA("Recetas"),
    CURSO("Cursos"),
    VIDEO("Videos")
}

//Contenido del catalogo
data class Contenido(
    val id: Int,
    val titulo: String,
    val descripcion: String,
    val categoria: CategoriaContenido,
    val duracion: String
)