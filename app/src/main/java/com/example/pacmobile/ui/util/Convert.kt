package com.example.pacmobile.ui.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun pxToDp(px: Double): Dp {
    // Obtém a densidade da tela atual
    val density = LocalDensity.current.density
    // Converte px para dp e retorna como Dp
    return (px / density).dp
}
