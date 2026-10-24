package com.masterlab.grupo13.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.masterlab.grupo13.componentes.TarjetaContenido
import com.masterlab.grupo13.componentes.FiltroCategorias
import com.masterlab.grupo13.model.CategoriaContenido
import com.masterlab.grupo13.model.Contenido
import com.masterlab.grupo13.repository.ContenidoRepositorio
import com.masterlab.grupo13.ui.theme.MasterLab_Grupo13Theme
import com.masterlab.grupo13.ui.utils.obtenerWindowSizeClass
import com.masterlab.grupo13.viewmodel.ContenidoViewModel


// Parte 1: obtiene los datos del ViewModel y el tamaño de la ventana
@Composable
fun PantallaInicio(viewModel: ContenidoViewModel = viewModel()) {
    val claseVentana = obtenerWindowSizeClass()
    val contenidos by viewModel.contenidos.collectAsState()
    val categoria by viewModel.categoriaSelecccionada.collectAsState()

    ContenidoInicio(
        claseAncho = claseVentana.widthSizeClass,
        contenidos = contenidos,
        categoriaSeleccionada = categoria,
        alSeleccionarCategoria = viewModel::seleccionarCategoria
    )
}

// Parte 2: solo dibuja. Elige el diseño según el ancho de la pantalla
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContenidoInicio(
    claseAncho: WindowWidthSizeClass,
    contenidos: List<Contenido>,
    categoriaSeleccionada: CategoriaContenido?,
    alSeleccionarCategoria: (CategoriaContenido?) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Master Martini Academia") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { relleno ->
        Column(
            modifier = Modifier
                .padding(relleno)
                .fillMaxSize()
        ) {
            FiltroCategorias(
                categoriaSeleccionada = categoriaSeleccionada,
                alSeleccionar = alSeleccionarCategoria
            )

            when (claseAncho) {
                WindowWidthSizeClass.Compact -> ListaContenidos(contenidos)
                WindowWidthSizeClass.Medium -> CuadriculaContenidos(contenidos, columnas = 2)
                else -> CuadriculaContenidos(contenidos, columnas = 3)
            }
        }
    }
}

@Composable
fun FiltroCategorias(
    categoriaSeleccionada: CategoriaContenido?,
    alSeleccionar: (CategoriaContenido?) -> Unit
) {
    TODO("Not yet implemented")
}

// Diseño compacto: una sola columna
@Composable
private fun ListaContenidos(contenidos: List<Contenido>) {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(contenidos) { contenido ->
            TarjetaContenido(contenido)
        }
    }
}

// Diseño mediano y expandido: cuadrícula con más columnas
@Composable
private fun CuadriculaContenidos(contenidos: List<Contenido>, columnas: Int) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(columnas),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(contenidos) { contenido ->
            TarjetaContenido(contenido)
        }
    }
}


// Vistas previas de los tres tamaños
@Preview(name = "Compacta", widthDp = 360, heightDp = 800, showBackground = true)
@Composable
fun VistaPreviaInicioCompacta() {
    MasterLab_Grupo13Theme {
        ContenidoInicio(
            claseAncho = WindowWidthSizeClass.Compact,
            contenidos = ContenidoRepositorio.obtenerContenidos(),
            categoriaSeleccionada = null,
            alSeleccionarCategoria = {}
        )
    }
}

@Preview(name = "Mediana", widthDp = 700, heightDp = 900, showBackground = true)
@Composable
fun VistaPreviaInicioMediana() {
    MasterLab_Grupo13Theme {
        ContenidoInicio(
            claseAncho = WindowWidthSizeClass.Medium,
            contenidos = ContenidoRepositorio.obtenerContenidos(),
            categoriaSeleccionada = null,
            alSeleccionarCategoria = {}
        )
    }
}

@Preview(name = "Expandida", widthDp = 1100, heightDp = 800, showBackground = true)
@Composable
fun VistaPreviaInicioExpandida() {
    MasterLab_Grupo13Theme {
        ContenidoInicio(
            claseAncho = WindowWidthSizeClass.Expanded,
            contenidos = ContenidoRepositorio.obtenerContenidos(),
            categoriaSeleccionada = null,
            alSeleccionarCategoria = {}
        )
    }
}