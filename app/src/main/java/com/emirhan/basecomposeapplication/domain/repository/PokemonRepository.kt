package com.emirhan.basecomposeapplication.domain.repository

import com.emirhan.basecomposeapplication.data.remote.dto.GetPokemonResponse

interface PokemonRepository {
    suspend fun getPokemons(): GetPokemonResponse
}