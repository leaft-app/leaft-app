package com.example.pacmobile.ui.presentation.components

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun LoadingAnimation() {
    val colorScheme = MaterialTheme.colorScheme
    val colors = listOf(colorScheme.primary, colorScheme.secondary, colorScheme.tertiary)

    val transition = rememberInfiniteTransition(label = "Loading")

    val color1 by transition.animateColor(
        initialValue = colors[0],
        targetValue = colors[1],
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1500, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )
    val color2 by transition.animateColor(
        initialValue = colors[1],
        targetValue = colors[2],
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1500, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )
    val color3 by transition.animateColor(
        initialValue = colors[2],
        targetValue = colors[0],
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1500, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )

    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        Box(
            modifier = Modifier
                .size(10.dp)
                .background(color1, shape = CircleShape)
        )
        Box(
            modifier = Modifier
                .size(10.dp)
                .background(color2, shape = CircleShape)
        )
        Box(
            modifier = Modifier
                .size(10.dp)
                .background(color3, shape = CircleShape)
        )
    }
}