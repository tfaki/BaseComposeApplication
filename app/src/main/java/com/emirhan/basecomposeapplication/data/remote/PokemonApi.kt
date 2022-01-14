package com.emirhan.basecomposeapplication.data.remote

import com.emirhan.basecomposeapplication.data.remote.dto.GetPokemonResponse
import retrofit2.http.GET

interface PokemonApi {
    @GET("cards?hp=gte99")
    suspend fun getPokemons(): GetPokemonResponse
}