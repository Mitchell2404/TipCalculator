package com.example.tipcalculator.ui.model

import androidx.annotation.DrawableRes

data class Artwork(
    val title: String,
    val artist: String,
    val year: String,
    @DrawableRes val imageRes: Int
)