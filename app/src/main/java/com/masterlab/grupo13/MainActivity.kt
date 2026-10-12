package com.masterlab.grupo13

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.masterlab.grupo13.navigation.NavigationEvent
import com.masterlab.grupo13.navigation.Screen
import com.masterlab.grupo13.ui.screens.ProfileScreen
import com.masterlab.grupo13.ui.screens.SettingsScreen
import com.masterlab.grupo13.ui.theme.MasterLab_Grupo13Theme
import com.masterlab.grupo13.viowmodel.MainViewModel
import kotlinx.coroutines.flow.collectLatest
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.masterlab.grupo13.ui.screens.HomeScreen


@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MasterLab_Grupo13Theme {
                val viewModel: MainViewModel = viewModel()
                val navController = rememberNavController()

                LaunchedEffect(Unit) {
                    viewModel.navigationEvents.collectLatest { event ->
                        when (event) {
                            is NavigationEvent.NavigateTo -> {
                                navController.navigate(event.route.route) {
                                    event.popUpToRoute?.let {
                                        popUpTo(it.route) { inclusive = event.inclusive }
                                    }
                                    launchSingleTop = event.singleton
                                    restoreState = true
                                }
                            }
                            is NavigationEvent.PopBackStack -> navController.popBackStack()
                            is NavigationEvent.NavigateUp -> navController.navigateUp()
                        }
                    }
                }

                Scaffold(modifier = Modifier.fillMaxSize()) {innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = Screen.Home.route,
                        modifier = Modifier.padding(innerPadding)
                    ){
                        composable(Screen.Home.route){
                            HomeScreen(navController = navController, viewModel = viewModel)
                        }
                        composable(Screen.Profile.route){
                            ProfileScreen(navController = navController, viewModel = viewModel)
                        }
                        composable(Screen.Settings.route){
                            SettingsScreen(navController = navController, viewModel = viewModel)
                        }
                    }
                }
            }
        }
    }
}