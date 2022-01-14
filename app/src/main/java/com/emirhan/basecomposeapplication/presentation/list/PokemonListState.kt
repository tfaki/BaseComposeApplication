package com.emirhan.basecomposeapplication.presentation.list

import com.emirhan.basecomposeapplication.domain.model.Pokemon

data class PokemonListState(
    val isLoading: Boolean = false,
    val pokemons: List<Pokemon> = emptyList(),
    val error: String = ""
)