package com.masterlab.grupo13.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Un solo esquema de colores, claro y con buen contraste
private val EsquemaClaro = lightColorScheme(
    primary = AzulMarino,
    onPrimary = Color.White,
    secondary = Dorado,
    onSecondary = TextoOscuro,
    background = FondoClaro,
    surface = FondoClaro,
    onBackground = TextoOscuro,
    onSurface = TextoOscuro
)

@Composable
fun MasterLab_Grupo13Theme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = EsquemaClaro,
        typography = Typography,
        content = content
    )
}