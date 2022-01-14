package com.emirhan.basecomposeapplication.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.emirhan.basecomposeapplication.common.BaseCompose
import com.emirhan.basecomposeapplication.presentation.list.PokemonListScreen
import com.emirhan.basecomposeapplication.presentation.list.PokemonListViewModel
import com.emirhan.basecomposeapplication.ui.theme.BaseComposeApplicationTheme
import com.ramcosta.composedestinations.DestinationsNavHost
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BaseComposeApplicationTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(navController = navController,  startDestination = Screen.PokemonListScreen.route) {
                        composable(
                            route = Screen.PokemonListScreen.route
                        ) {
                            BaseCompose<PokemonListViewModel> {
                                PokemonListScreen(navController = navController, it)
                            }
                        }
                        composable(
                            route = Screen.PokemonDetailScreen.route
                        ) {

                        }
                    }
                }
            }
        }
    }
}
