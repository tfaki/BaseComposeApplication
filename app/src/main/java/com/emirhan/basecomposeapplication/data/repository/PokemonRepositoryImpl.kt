package com.emirhan.basecomposeapplication.data.repository

import com.emirhan.basecomposeapplication.data.remote.PokemonApi
import com.emirhan.basecomposeapplication.data.remote.dto.GetPokemonResponse
import com.emirhan.basecomposeapplication.domain.repository.PokemonRepository

class PokemonRepositoryImpl(
    private val api: PokemonApi
) : PokemonRepository {
    override suspend fun getPokemons(): GetPokemonResponse = api.getPokemons() //dao.getPokemons()
}