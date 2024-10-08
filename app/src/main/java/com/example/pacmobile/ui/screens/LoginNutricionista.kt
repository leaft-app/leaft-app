package com.example.pacmobile.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pacmobile.R
import com.example.pacmobile.ui.theme.AppTheme


@Composable
fun LoginNutricionistaStateHandler(){
    val emailState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }

    LoginNutricionista(
        email = emailState.value,
        onEmailChange = { emailState.value = it },
        password = passwordState.value,
        onPasswordChange = { passwordState.value = it },
        onLoginClick = { /* Handle login click */ },
        onForgotPasswordClick = { /* Handle forgot password click */ },
        onSignUpClick = { /* Handle sign-up click */ }
    )
}


@Composable
fun LoginNutricionista(
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
        BasicTextField(
            value = email,
            onValueChange = onEmailChange,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            singleLine = true,
            textStyle = TextStyle(fontSize = 16.sp),
            decorationBox = { innerTextField ->
                Column() {
                    Text(text = "E-mail", style = TextStyle(color = MaterialTheme.colorScheme.onSecondary))
                    Box(modifier = Modifier.padding(vertical = 16.dp)) {
                        innerTextField()
                    }
                }
            }
        )

        // Campo de Senha
        BasicTextField(
            value = password,
            onValueChange = onPasswordChange,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp),
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            textStyle = TextStyle(fontSize = 16.sp),
            decorationBox = { innerTextField ->
                Column {
                    Text(text = "Senha", style = TextStyle(color = MaterialTheme.colorScheme.onSecondary))
                    Box(modifier = Modifier.padding(vertical = 8.dp)) {
                        innerTextField()
                    }
                }
            }
        )

        // Botão "Entrar"
        Button(
            onClick = onLoginClick,
            colors = ButtonDefaults.buttonColors(containerColor =  MaterialTheme.colorScheme.primary),
            modifier = Modifier
                .padding(bottom = 64.dp)
                .size(220.dp, 48.dp)
        ) {
            Text(text = "Entrar", color = MaterialTheme.colorScheme.onPrimary)
        }

        // Texto "Esqueci minha senha" e "Não tenho conta"
        TextButton(
            onClick = onForgotPasswordClick,
            modifier = Modifier
                .fillMaxWidth()

        ) {
            Text(text = "Esqueci minha senha >", color = MaterialTheme.colorScheme.primary)
        }

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
    val emailState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }

    AppTheme(dynamicColor = false, darkTheme = false) {
        LoginNutricionista(
            email = emailState.value,
            onEmailChange = { emailState.value = it },
            password = passwordState.value,
            onPasswordChange = { passwordState.value = it },
            onLoginClick = { /* Handle login click */ },
            onForgotPasswordClick = { /* Handle forgot password click */ },
            onSignUpClick = { /* Handle sign-up click */ }
        )
    }
}
