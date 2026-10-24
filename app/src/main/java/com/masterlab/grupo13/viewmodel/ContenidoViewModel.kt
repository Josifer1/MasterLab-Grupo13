package com.masterlab.grupo13.viewmodel

import androidx.lifecycle.ViewModel
import com.masterlab.grupo13.model.CategoriaContenido
import com.masterlab.grupo13.model.Contenido
import com.masterlab.grupo13.repository.ContenidoRepositorio
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ContenidoViewModel : ViewModel(){

    //Lista Completa, sin filtrar
    private val todosLosContenidos = ContenidoRepositorio.obtenerContenidos()

    //Categoría elegida (null significa "Todas")
    private val _categoriaSelecccionada = MutableStateFlow<CategoriaContenido?>(null)
    val categoriaSelecccionada: StateFlow<CategoriaContenido?> = _categoriaSelecccionada

    //Lista que se muestra en pantalla
    private val _contenidos = MutableStateFlow(todosLosContenidos)
    val contenidos: StateFlow<List<Contenido>> = _contenidos

    //La logica del filtro vive aquí, no en la pantalla
    fun seleccionarCategoria(categoria: CategoriaContenido?){
        _categoriaSelecccionada.value = categoria
        _contenidos.value = if (categoria == null) {
            todosLosContenidos
        } else {
            todosLosContenidos.filter { it.categoria == categoria }
        }
    }
}