package com.example.pacmobile.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pacmobile.R
import com.example.pacmobile.ui.theme.AppTheme
import com.example.pacmobile.ui.util.convertPxToDp

@Composable
fun SelectionRoleScreen(modifier: Modifier = Modifier) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.background_image),
            contentDescription = "Food Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF006D00).copy(alpha = 0.4f))
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = convertPxToDp(36)),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.weight(1f))

            Image(
                painter = painterResource(id = R.drawable.icon),
                contentDescription = "Image Logo",
                modifier = Modifier.size(177.dp, 198.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = stringResource(R.string.vem_mudar_seus_planos_e_acompanhamentos_com_o_leaft),
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .size(309.dp, 93.dp)
                ,
                style = MaterialTheme.typography.labelLarge,
                fontSize =26.sp,
                minLines = 3,
                textAlign = TextAlign.Left
            )

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = { /* TODO: Navegar para a próxima tela */ },
                colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.background),
                modifier = Modifier
                    .size(width = 280.dp, height = 53.dp),
                shape = RectangleShape
            ) {
                Text(text = "Sou um Cliente", color = Color.Black)
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Botão "Sou um Nutricionista"
            Button(
                onClick = { /* TODO: Navegar para a próxima tela */ },
                colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary),
                modifier = Modifier
                    .size(width = 280.dp, height = 53.dp),
                shape = RectangleShape
            ) {
                Text(text = "Sou um Nutricionista", color = Color.White)
            }

            Spacer(modifier = Modifier.height(16.dp))

            TextButton(onClick = { /* TODO: Navegar para a criação de conta */ }) {
                Text(text = "Ainda não tenho uma conta", color = Color.White)
            }

            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewScreen() {
    AppTheme(dynamicColor = false) {
        SelectionRoleScreen()
    }
}
