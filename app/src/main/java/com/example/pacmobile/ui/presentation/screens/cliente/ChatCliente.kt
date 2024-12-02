package com.example.pacmobile.ui.presentation.screens.cliente

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.Image
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pacmobile.R
import com.example.pacmobile.ui.presentation.theme.AppTheme

@Composable
fun ChatClienteHandler(
    navController: NavController = androidx.navigation.compose.rememberNavController(),
    marginTop: Dp = 16.dp // Definindo a margem superior como parâmetro com valor padrão
) {
    Scaffold(
        bottomBar = {
            ClientBottomMenu(
                onAddMealClick = { navController.navigate("add-refeicao") },
                onMessagesClick = { navController.navigate("chat-cliente") } // Permanece no mesmo lugar
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            Text(
                text = "Mensagens",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp, // Ajustando o texto para 18px
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = marginTop, top = 16.dp) // Defina a margem que você deseja
            )

            // Divisor retangular abaixo do texto "Mensagens"
            Spacer(modifier = Modifier.height(8.dp)) // Espaço entre o texto e o divisor

            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                HorizontalDivider(
                color = Color.Gray, // Cor do divisor
                thickness = 1.dp, // Espessura do divisor
                modifier = Modifier
                    .padding(top = 16.dp) // Margem que você pode definir
                    .width(340.dp)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth() // Preenche a largura disponível
                    .padding(start = marginTop, top = 16.dp), // Defina a margem que você deseja
                contentAlignment = Alignment.Center
            ) {
                RefeicaoItem(
                    refeicao = "Lanche", // substituir em banco
                    data = "23 de Setembro", // substituir em banco
                    hora = "08:37", // substituir em banco
                    icon = painterResource(id = R.drawable.group_32) // Ícone de exemplo (substitua com o ícone que deseja)
                )
            }
        }
    }
}

@Composable
fun RefeicaoItem(refeicao: String, data: String, hora: String, icon: androidx.compose.ui.graphics.painter.Painter) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start // Garante que o conteúdo fique alinhado à esquerda
    ) {
        // Nome da refeição
        Text(
            text = refeicao,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier.weight(1f),
        )

        // Data e hora
        Text(
            text = "$data, $hora",
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.weight(1.6f),
        )

        // Ícone
        Image(
            painter = icon,
            contentDescription = "Ícone do post",
            modifier = Modifier
                .size(24.dp) // Define o tamanho do ícone
                .padding(start = 4.dp) // Espaço entre o ícone e o texto
                .weight(1f)
        )
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewChatClientHandler() {
    AppTheme(dynamicColor = false, darkTheme = false) {
        ChatClienteHandler(navController = androidx.navigation.compose.rememberNavController())
    }
}
