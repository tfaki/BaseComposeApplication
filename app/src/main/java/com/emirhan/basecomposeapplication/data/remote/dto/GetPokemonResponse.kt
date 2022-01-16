package com.emirhan.basecomposeapplication.data.remote.dto

import com.emirhan.basecomposeapplication.common.BaseResponse

data class GetPokemonResponse(
    val cards: List<PokemonCard>
) : BaseResponse()
