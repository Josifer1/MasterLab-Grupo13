package com.masterlab.grupo13.componentes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.masterlab.grupo13.model.CategoriaContenido
import com.masterlab.grupo13.model.Contenido

// Tarjeta que muestra un contenido del catálogo
@Composable
fun TarjetaContenido(contenido: Contenido, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Fila superior: ícono + nombre de la categoría
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = iconoDe(contenido.categoria),
                    // el texto de al lado ya lo describe
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(32.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = contenido.categoria.titulo,
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.primary
                )
            }

            Text(text = contenido.titulo, style = MaterialTheme.typography.titleLarge)
            Text(text = contenido.descripcion, style = MaterialTheme.typography.bodyLarge)
            Text(
                text = "Duración: ${contenido.duracion}",
                style = MaterialTheme.typography.labelLarge
            )
        }
    }
}

// Elige el ícono según la categoría
private fun iconoDe(categoria: CategoriaContenido): ImageVector {
    return when (categoria) {
        CategoriaContenido.RECETA -> Icons.Default.Favorite
        CategoriaContenido.CURSO -> Icons.Default.Star
        CategoriaContenido.VIDEO -> Icons.Default.PlayArrow
    }
}