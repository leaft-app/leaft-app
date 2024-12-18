package com.example.pacmobile.ui.presentation.screens.nutricionista

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
fun SignUpNutricionistaStateHandler(navController: NavController = androidx.navigation.compose.rememberNavController()) {
    val nameState = remember { mutableStateOf("") }
    val emailState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }

    SignUpNutricionista(
        name = nameState.value,
        onNameChange = { nameState.value = it },
        email = emailState.value,
        onEmailChange = { emailState.value = it },
        password = passwordState.value,
        onPasswordChange = { passwordState.value = it },
        onSignUpClick = {
            // Ação ao clicar em "Cadastrar" (navegar para a próxima tela)
            navController.navigate("login-nutricionista") {
                popUpTo("sign-up-nutricionista") { inclusive = true }
            }
        }
    )
}

@Composable
fun SignUpNutricionista(
    name: String,
    onNameChange: (String) -> Unit,
    email: String,
    onEmailChange: (String) -> Unit,
    password: String,
    onPasswordChange: (String) -> Unit,
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

        // Texto "Faça seu Cadastro"
        Text(
            text = "Faça seu Cadastro",
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(bottom = 24.dp),
            fontSize = 26.sp
        )

        // Campo de Nome
        CustomTextField(
            label = "Nome",
            value = name,
            onValueChange = onNameChange
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

        Spacer(modifier = Modifier.height(16.dp))

        // Botão "Cadastrar"
        CustomButton(
            text = "Cadastrar",
            onClick = onSignUpClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewSignUp() {
    AppTheme(dynamicColor = false, darkTheme = false) {
        SignUpNutricionistaStateHandler()
    }
}
