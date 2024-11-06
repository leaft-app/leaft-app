package com.example.pacmobile.ui.presentation.screens.cliente

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import com.example.pacmobile.ui.presentation.components.CustomTextField
import com.example.pacmobile.ui.presentation.theme.AppTheme

@Composable
fun NovaSenhaClienteStateHandler(navController: NavController = androidx.navigation.compose.rememberNavController()) {
    val senhaState = remember { mutableStateOf("") }

    NovaSenhaCliente(
        senha = senhaState.value,
        onSenhaChange = { senhaState.value = it },
        onEnviarClick = {
            // Navegação para a próxima tela
            navController.navigate("login-cliente") {
                popUpTo("nova-senha-cliente") { inclusive = true }
            }
        },
    )
}

@Composable
fun NovaSenhaCliente(
    senha: String,
    onSenhaChange: (String) -> Unit,
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
            painter = painterResource(id = R.drawable.icon), // Mantenha o ícone
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .padding(bottom = 22.dp)
                .size(177.dp, 198.dp)
        )

        // Título "Insira sua nova senha"
        Text(
            text = "Nova Senha",
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(bottom = 32.dp),
            fontSize = 24.sp
        )

        // Texto "Insira sua senha"
        Text(
            text = "Insira sua senha",
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier
                .padding(bottom = 32.dp)
                .align(Alignment.Start),
            fontSize = 16.sp,
        )

        // Campo de Senha
        CustomTextField(
            label = "Senha",
            value = senha,
            onValueChange = onSenhaChange,
            isPassword = true
        )

        // Botão "Enviar"
        CustomButton(
            text = "Enviar",
            onClick = onEnviarClick,
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewNovaSenha() {
    AppTheme(dynamicColor = false, darkTheme = false) {
        NovaSenhaClienteStateHandler()
    }
}
