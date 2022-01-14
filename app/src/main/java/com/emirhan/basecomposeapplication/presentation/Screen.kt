package com.emirhan.basecomposeapplication.presentation

sealed class Screen(val route: String) {
    object PokemonListScreen : Screen("pokemon_list")
    object PokemonDetailScreen : Screen("pokemon_detail")
}
