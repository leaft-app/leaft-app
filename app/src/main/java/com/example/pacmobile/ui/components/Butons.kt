package com.example.pacmobile.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CustomButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor =  MaterialTheme.colorScheme.primary),
        modifier = Modifier
            .padding(bottom = 64.dp)
            .size(220.dp, 48.dp)
    ) {
        Text(text = "Entrar", color = MaterialTheme.colorScheme.onPrimary)
    }
}
