package com.emirhan.basecomposeapplication.presentation.detail

import com.emirhan.basecomposeapplication.domain.model.Pokemon

data class PokemonDetailState(
    val isLoading: Boolean = false,
    val pokemon: Pokemon? = null,
    val error: String = ""
)