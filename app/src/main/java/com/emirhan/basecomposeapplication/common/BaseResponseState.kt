package com.emirhan.basecomposeapplication.common

data class BaseResponseState<T>(
    var response: T? = null,
    override var isLoading: Boolean = false,
    override var error: String? = ""
) : BaseState()
