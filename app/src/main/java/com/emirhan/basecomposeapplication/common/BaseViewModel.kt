package com.emirhan.basecomposeapplication.common

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

open class BaseViewModel : ViewModel() {
    val isLoading = MutableLiveData<Boolean>()
    val error = MutableLiveData<String>()

    fun <T> handleRequest(
        flow: Flow<Resource<T>>,
        onSuccess: (T) -> Unit,
        onError: ((String) -> Unit)? = null,
        onLoading: (() -> Unit)? = null,
        onComplete: (() -> Unit)? = null
    ) {
        flow.onEach { result ->
            when (result) {
                is Resource.Success -> {
                    result.data?.let { response ->
                        onSuccess(response)
                    }
                }
                is Resource.Error -> {
                    if (onError != null)
                        onError.invoke(result.message ?: "Unexpected error occured!")
                    else {
                        error.value = result.message
                    }
                }
                is Resource.Loading -> {
                    onLoading?.invoke()
                    if (onLoading != null)
                        onLoading.invoke()
                    else
                        isLoading.value = true
                }
            }
            onComplete?.invoke()
            isLoading.value = false
        }.launchIn(viewModelScope)
    }
}