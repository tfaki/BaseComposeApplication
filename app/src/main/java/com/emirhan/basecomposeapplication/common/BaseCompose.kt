package com.emirhan.basecomposeapplication.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.talhafaki.composablesweettoast.util.SweetToastUtil.SweetError

@Composable
inline fun <reified T : BaseViewModel> BaseCompose(
    baseViewModel: T = hiltViewModel(),
    content: (@Composable (viewModel: T) -> Unit)
) {
    Box(modifier = Modifier.fillMaxSize()) {
        content.invoke(baseViewModel)

        if (baseViewModel.isLoading.value == true) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
        if (!baseViewModel.error.value.isNullOrBlank()) {
            SweetError(baseViewModel.error.value ?: "Unexpected error!")
        }
    }
}