package com.emirhan.basecomposeapplication.presentation.list

import androidx.compose.runtime.mutableStateOf
import com.emirhan.basecomposeapplication.common.BaseViewModel
import com.emirhan.basecomposeapplication.domain.use_case.GetPokemonsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val getPokemonsUseCase: GetPokemonsUseCase
) : BaseViewModel() {

    private val _state = mutableStateOf(PokemonListState())
    val state = _state

    init {
        getPokemons()
    }

    private fun getPokemons() {
        handleRequest(getPokemonsUseCase(), onSuccess = {
            state.value = PokemonListState(pokemons = it)
        })
    }

}