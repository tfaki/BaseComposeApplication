package com.emirhan.basecomposeapplication.presentation.list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.emirhan.basecomposeapplication.domain.model.Pokemon

@Composable
fun PokemonListItem(
    pokemon: Pokemon,
    onItemClick: (Pokemon) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(pokemon) }
            .padding(20.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = pokemon.name,
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis
        )
    }
}