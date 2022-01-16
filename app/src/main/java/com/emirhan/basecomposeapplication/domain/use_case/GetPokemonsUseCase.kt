package com.emirhan.basecomposeapplication.domain.use_case

import android.util.Log
import com.emirhan.basecomposeapplication.common.Resource
import com.emirhan.basecomposeapplication.data.remote.dto.PokemonCard
import com.emirhan.basecomposeapplication.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetPokemonsUseCase @Inject constructor(
    private val repository: PokemonRepository
) {
    operator fun invoke(): Flow<Resource<List<PokemonCard>>> = flow {
        try {
            emit(Resource.Loading())
            val pokemons = repository.getPokemons().cards
            emit(Resource.Success(pokemons))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection!"))
        } catch (e: Exception) {
            Log.e("Error", e.localizedMessage ?: "hata")
        }
    }
}