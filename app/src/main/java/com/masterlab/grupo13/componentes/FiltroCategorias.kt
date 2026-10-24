package com.masterlab.grupo13.componentes

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.masterlab.grupo13.model.CategoriaContenido

// Fila de botones para filtrar el catálogo por categoría
@Composable
fun FiltroCategorias(
    categoriaSeleccionada: CategoriaContenido?,
    alSeleccionar: (CategoriaContenido?) -> Unit
) {
    Row(
        modifier = Modifier
            .horizontalScroll(rememberScrollState()) // se desliza si no cabe
            .padding(horizontal = 16.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // "Todos" = sin filtro (categoría nula)
        ChipCategoria(
            texto = "Todos",
            seleccionado = categoriaSeleccionada == null,
            alPresionar = { alSeleccionar(null) }
        )

        // Un botón por cada categoría
        CategoriaContenido.entries.forEach { categoria ->
            ChipCategoria(
                texto = categoria.titulo,
                seleccionado = categoriaSeleccionada == categoria,
                alPresionar = { alSeleccionar(categoria) }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ChipCategoria(texto: String, seleccionado: Boolean, alPresionar: () -> Unit) {
    FilterChip(
        selected = seleccionado,
        onClick = alPresionar,
        label = { Text(text = texto, style = MaterialTheme.typography.labelLarge) },
        colors = FilterChipDefaults.filterChipColors(
            selectedContainerColor = MaterialTheme.colorScheme.primary,
            selectedLabelColor = MaterialTheme.colorScheme.onPrimary
        )
    )
}