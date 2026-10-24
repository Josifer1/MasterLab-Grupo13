package com.masterlab.grupo13.repository

import com.masterlab.grupo13.model.Contenido
import com.masterlab.grupo13.model.CategoriaContenido

//Simula de donde vieen los datos, solo afecto de pruebas mas adelante se debe modificar con Room
object ContenidoRepositorio{

    fun obtenerContenidos(): List <Contenido> {
        return listOf(
            Contenido(1, "Brownie de chocolate intenso", "Receta simple con cobertura de chocolate semiamargo.", CategoriaContenido.RECETA, "40 min"),
            Contenido(2, "Empanadas de pino al horno", "Masa casera y relleno tradicional, listas para vender.", CategoriaContenido.RECETA, "50 min"),
            Contenido(3, "Galletas de mantequilla", "Base para galletas decoradas y de vitrina.", CategoriaContenido.RECETA, "35 min"),
            Contenido(4, "Chocolatería: temperado y bombones", "Curso de especialidad con técnicas de temperado.", CategoriaContenido.CURSO, "6 clases"),
            Contenido(5, "Pastelería de vitrina", "Tortas y postres individuales para tu local.", CategoriaContenido.CURSO, "8 clases"),
            Contenido(6, "Heladería artesanal", "Mezclas base, texturas y conservación.", CategoriaContenido.CURSO, "5 clases"),
            Contenido(7, "Masas de hoja y bollería", "Laminado, fermentación y horneo de croissants.", CategoriaContenido.CURSO, "7 clases"),
            Contenido(8, "Cómo temperar chocolate paso a paso", "Video técnico con el método de siembra.", CategoriaContenido.VIDEO, "8 min"),
            Contenido(9, "Laminado de masa de hoja", "Video técnico sobre pliegues y reposos.", CategoriaContenido.VIDEO, "12 min"),
            Contenido(10, "Puntos de horneo", "Video técnico para evitar masas crudas o secas.", CategoriaContenido.VIDEO, "10 min")
        )
    }
}