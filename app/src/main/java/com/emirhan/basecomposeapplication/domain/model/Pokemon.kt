package com.emirhan.basecomposeapplication.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pokemon(
    val id: String,
    val name: String,
    val artistName: String,
    val image: String
) : Parcelable
