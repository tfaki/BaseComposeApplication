package com.emirhan.basecomposeapplication.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.talhafaki.composablesweettoast.util.SweetToastUtil.SweetSuccess

@Composable
inline fun <reified T : BaseViewModel> BaseCompose(
    baseViewModel: T = hiltViewModel(),
    content: (@Composable (viewModel: T) -> Unit)
) {
    Box(modifier = Modifier.fillMaxSize()) {
        content.invoke(baseViewModel)

        if (baseViewModel.isLoading.value == true) {
            SweetSuccess("Success!")

        }

        baseViewModel.isLoading.observeForever {
            if (it) {
                // TODO
                //CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }

        baseViewModel.error.observeForever {
            if (!it.isNullOrBlank()) {
                // TODO
                //SweetError(message = it, duration = Toast.LENGTH_SHORT)
            }
        }
    }
}