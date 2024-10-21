package com.example.pacmobile.ui.screens.cliente

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
import com.example.pacmobile.ui.components.CustomButton
import com.example.pacmobile.ui.components.CustomTextField
import com.example.pacmobile.ui.theme.AppTheme

@Composable
fun EsqueceuSenhaClienteStateHandler(navController: NavController = androidx.navigation.compose.rememberNavController()) {
    val emailState = remember { mutableStateOf("") }

    EsqueceuSenhaCliente(
        email = emailState.value,
        onEmailChange = { emailState.value = it },
        onLoginClick = {
            navController.navigate("codigo-recuperação-cliente") {
                popUpTo("forgot-password-cliente") { inclusive = true }
            }
        },
    )
}

@Composable
fun EsqueceuSenhaCliente(
    email: String,
    onEmailChange: (String) -> Unit,
    onLoginClick: () -> Unit,
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

        // Texto "Esqueceu sua senha?"
        Text(
            text = "Esqueceu sua senha?",
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(bottom = 102.dp),
            fontSize = 24.sp
        )

        //Texto "Digite seu e-mail cadastrado"
        Text(
            text = "Digite seu e-mail cadastrado",
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier
                .padding(bottom = 32.dp)
                .align(Alignment.Start),
            fontSize = 16.sp,
        )

        // Campo de E-mail
        CustomTextField(
            label = "E-mail",
            value = email,
            onValueChange = onEmailChange
        )

        // Botão "Entrar"
        CustomButton(
            text = "Entrar",
            onClick = onLoginClick,
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewEsqueceuSenhaCliente() {
    AppTheme(dynamicColor = false, darkTheme = false) {
        EsqueceuSenhaClienteStateHandler()
    }
}
