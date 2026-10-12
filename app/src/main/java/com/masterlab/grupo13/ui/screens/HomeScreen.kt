package com.masterlab.grupo13.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.masterlab.grupo13.viowmodel.MainViewModel
import kotlinx.coroutines.launch
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import com.masterlab.grupo13.navigation.Screen
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: MainViewModel = viewModel()
){
    //Estado del menu lateral y scope para abrilo o Cerrarlo
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Text("*Menu*", modifier = Modifier.padding(16.dp))
                NavigationDrawerItem(
                    label = {Text("Ir a Perfil")},
                    selected = false,
                    onClick = {
                        scope.launch { drawerState.close() }
                        viewModel.navigateTo(Screen.Profile)
                    }
                )
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {Text("Pantalla HOME")},
                    navigationIcon = {
                        IconButton(onClick = {scope.launch { drawerState.open() }}) {
                            Icon(Icons.Default.Menu, contentDescription = "menu")
                        }
                    }
                )
            }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text("¡Bienvenido a la APP de Inicio")
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = {viewModel.navigateTo(Screen.Settings)}) {
                    Text("Ir a configuracion")
                }
            }
        }
    }
}