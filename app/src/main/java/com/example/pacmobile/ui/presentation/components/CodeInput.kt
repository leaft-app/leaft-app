package com.example.pacmobile.ui.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CodeInputField(
    codigo: String,
    position: Int,
    onCodigoChange: (String) -> Unit
) {
    BasicTextField(
        value = codigo.getOrNull(position)?.toString() ?: "",
        onValueChange = { newChar ->
            if (newChar.length == 1 && newChar[0].isDigit()) {
                val updatedCodigo = codigo.substring(0, position) + newChar + codigo.substring(position + 1)
                onCodigoChange(updatedCodigo)
            }
        },
        modifier = Modifier
            .size(60.dp)  // Define o tamanho dos campos como na imagem
            .padding(horizontal = 8.dp) // Espaçamento entre os campos
            .background(Color(0xFFD3D4D1), shape = MaterialTheme.shapes.medium), // Fundo e borda arredondada
        textStyle = TextStyle(
            color = Color.Black,
            fontSize = 24.sp,
            textAlign = TextAlign.Center
        ),
        singleLine = true
    ) { innerTextField ->
        Box(
            contentAlignment = Alignment.Center
        ) {
            if (codigo.getOrNull(position) == null) {
                Text(
                    text = "0", // Placeholder
                    style = TextStyle(
                        color = Color.Gray,
                        fontSize = 24.sp,
                        textAlign = TextAlign.Center
                    )
                )
            }
            innerTextField()
        }
    }
}
