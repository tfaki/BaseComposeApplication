package com.emirhan.basecomposeapplication.common

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

open class BaseUseCase<T> {
    open operator fun invoke(): Flow<Resource<T>> = flow {

    }

}