package com.example.pacmobile.ui.presentation.screens.nutricionista

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pacmobile.R
import com.example.pacmobile.ui.presentation.components.CustomButton
import com.example.pacmobile.ui.presentation.theme.AppTheme
import com.example.pacmobile.ui.utils.CodeInputField

@Composable
fun CodigoRecuperacaoStateHandler(navController: NavController = androidx.navigation.compose.rememberNavController()) {
    val codigoState = remember { mutableStateOf("") }

    CodigoRecuperacao(
        codigo = codigoState.value,
        onCodigoChange = { codigoState.value = it },
        onEnviarClick = {
            navController.navigate("nova-senha-nutricionista") {
                popUpTo("codigo-recuperacao-nutricionista") { inclusive = true }
            }
        },
    )
}

@Composable
fun CodigoRecuperacao(
    codigo: String,
    onCodigoChange: (String) -> Unit,
    onEnviarClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .blur(100.dp, edgeTreatment = BlurredEdgeTreatment.Unbounded)
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.icon),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .padding(bottom = 22.dp)
                .size(177.dp, 198.dp)
        )

        Text(
            text = "Insira o código enviado para seu email",
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(bottom = 32.dp),
            fontSize = 24.sp
        )

        // Digitação do código de recuperação
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth().padding(horizontal = 32.dp)
        ) {
            repeat(4) { position ->
                CodeInputField(
                    codigo = codigo,
                    position = position,
                    onCodigoChange = onCodigoChange
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Botão "Enviar"
        CustomButton(
            text = "Enviar",
            onClick = onEnviarClick,
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewCodigoRecuperacao() {
    AppTheme(dynamicColor = false, darkTheme = false) {
        CodigoRecuperacaoStateHandler()
    }
}

