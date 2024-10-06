package com.example.pacmobile.ui.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp

@Composable
fun convertPxToDp(px: Int): Dp {
    val density = LocalDensity.current
    return with(density) { px.toDp() }
}
