package com.masterlab.grupo13.ui.theme


import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.masterlab.grupo13.ui.screens.HomeScreenCompacta
import com.masterlab.grupo13.ui.screens.HomeScreenExpandida
import com.masterlab.grupo13.ui.screens.HomeScreenMediana
import com.masterlab.grupo13.ui.utils.obtenerWindowSizeClass

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    val windowSizeClass = obtenerWindowSizeClass()

    when (windowSizeClass.widthSizeClass) {
        WindowWidthSizeClass.Compact -> HomeScreenCompacta()
        WindowWidthSizeClass.Medium -> HomeScreenMediana()
        WindowWidthSizeClass.Expanded -> HomeScreenExpandida()
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}