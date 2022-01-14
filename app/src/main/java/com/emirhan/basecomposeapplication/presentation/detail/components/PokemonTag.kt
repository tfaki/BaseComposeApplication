package com.emirhan.basecomposeapplication.presentation.detail.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun PokemonTag(
    tag: String
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        Text(
            text = tag,
            color = MaterialTheme.colors.primary,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.body2
        )
    }
}