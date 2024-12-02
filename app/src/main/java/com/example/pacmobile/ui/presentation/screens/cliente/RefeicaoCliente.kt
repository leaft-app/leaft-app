package com.example.pacmobile.ui.presentation.screens.cliente

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.pacmobile.R
import androidx.compose.material3.Text
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pacmobile.ui.presentation.theme.AppTheme

@Composable
fun RefeicaoClienteHandler(
    navController: NavController = androidx.navigation.compose.rememberNavController()
) {
    var selectedRefeicao by remember { mutableStateOf<String?>(null) }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.background_image),
            contentDescription = "Imagem de refeição",
            modifier = Modifier.fillMaxSize()
        )

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(top = 100.dp),  // Deixa a parte superior da modal no meio da tela
            shape = MaterialTheme.shapes.large,  // Cantos arredondados
            color = MaterialTheme.colorScheme.surface.copy(alpha = 0.9f), // Fundo branco com opacidade
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(16.dp)
            ) {
                // Ícone
                Image(
                    painter = painterResource(id = R.drawable.undraw_walking), // Substitua com o ícone desejado
                    contentDescription = "Ícone",
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 8.dp)
                )

                // Título da modal
                Text(
                    text = "Refeição realizada:",
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
            } // Column
        } // Surface
    } // Box
} // Main method

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewRefeicaoClient() {
    AppTheme(dynamicColor = false, darkTheme = false) {
        RefeicaoClienteHandler(navController = androidx.navigation.compose.rememberNavController())
    }
}