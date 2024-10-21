package com.example.pacmobile.ui.screens.cliente

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
fun LoginClienteStateHandler(navController: NavController = androidx.navigation.compose.rememberNavController()) {
    val emailState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }

    LoginCliente(
        email = emailState.value,
        onEmailChange = { emailState.value = it },
        password = passwordState.value,
        onPasswordChange = { passwordState.value = it },
        onLoginClick = {
            // Ação ao clicar em "Entrar" (navegar para a próxima tela)
            navController.navigate("home") {
                popUpTo("login-nutri") { inclusive = true }
            }
        },
        onForgotPasswordClick = {
            // Navegar para a tela de recuperação de senha
            navController.navigate("forgot-password-nutricionista") {
                popUpTo("login-nutri") { inclusive = true }
            }
        },
        onSignUpClick = {
            // Navegar para a tela de registro
            navController.navigate("sign-up-nutricionista") {
                popUpTo("login-nutri") { inclusive = true }
            }
        }
    )
}

@Composable
fun LoginCliente(
    email: String,
    onEmailChange: (String) -> Unit,
    password: String,
    onPasswordChange: (String) -> Unit,
    onLoginClick: () -> Unit,
    onForgotPasswordClick: () -> Unit,
    onSignUpClick: () -> Unit,
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

        // Texto "Faça seu login"
        Text(
            text = "Faça seu login",
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(bottom = 102.dp),
            fontSize = 24.sp
        )

        // Campo de E-mail
        CustomTextField(
            label = "E-mail",
            value = email,
            onValueChange = onEmailChange
        )

        // Campo de Senha
        CustomTextField(
            label = "Senha",
            value = password,
            onValueChange = onPasswordChange,
            isPassword = true
        )

        // Botão "Entrar"
        CustomButton(
            text = "Entrar",
            onClick = onLoginClick,
        )

        // Texto "Esqueci minha senha"
        TextButton(
            onClick = onForgotPasswordClick,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(text = "Esqueci minha senha >", color = MaterialTheme.colorScheme.primary)
        }

        // Texto "Não tenho conta"
        TextButton(
            onClick = onSignUpClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Não tenho conta >", color = MaterialTheme.colorScheme.primary)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewLogin() {
    AppTheme(dynamicColor = false, darkTheme = false) {
        LoginClienteStateHandler()
    }
}
