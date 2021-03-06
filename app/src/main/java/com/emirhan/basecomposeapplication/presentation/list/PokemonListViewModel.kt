package com.emirhan.basecomposeapplication.presentation.list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.emirhan.basecomposeapplication.common.BaseResponseState
import com.emirhan.basecomposeapplication.common.BaseViewModel
import com.emirhan.basecomposeapplication.data.remote.dto.PokemonCard
import com.emirhan.basecomposeapplication.domain.use_case.GetPokemonsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val getPokemonsUseCase: GetPokemonsUseCase
) : BaseViewModel() {

    private val mutableState: MutableState<BaseResponseState<List<PokemonCard>>> =
        mutableStateOf(BaseResponseState())
    val state: MutableState<BaseResponseState<List<PokemonCard>>> = mutableState

    init {
        getPokemons()
    }

    private fun getPokemons() {
        handleRequest(getPokemonsUseCase(), {
            mutableState.value = BaseResponseState(it)
        })
    }
}