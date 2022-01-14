package com.emirhan.basecomposeapplication.presentation.list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.emirhan.basecomposeapplication.presentation.list.components.PokemonListItem

@Composable
fun PokemonListScreen(
    navController: NavController,
    viewModel: PokemonListViewModel
) {
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(state.pokemons) { pokemon ->
                PokemonListItem(
                    pokemon = pokemon,
                    onItemClick = {

                    }
                )
            }
        }
    }
}
