package com.masterlab.grupo13

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.masterlab.grupo13.ui.theme.MasterLab_Grupo13Theme
import com.masterlab.grupo13.navigation.AppNavigation


@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MasterLab_Grupo13Theme {
                Scaffold {espacioInterno ->
                    //Aqui se inicia el flujo de navegacion del formulario
                    Box(modifier = Modifier.padding(espacioInterno)){
                        AppNavigation()
                    }
                }
            }
        }
    }
}