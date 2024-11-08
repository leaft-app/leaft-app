package com.example.pacmobile.ui.presentation.screens.cliente

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pacmobile.R
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.pacmobile.ui.presentation.theme.AppTheme


@Composable
fun ClientHomeScreen(navController: NavController = androidx.navigation.compose.rememberNavController()) {
    Scaffold(
        bottomBar = {
            ClientBottomMenu(
                onAddMealClick = { /* Ação para adicionar refeição */ },
                onMessagesClick = { navController.navigate("chat-cliente") }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.background)
        ) {
            ClientGreetingSection()
            ClientRecentActivitiesSection()
        }
    }
}

@Composable
fun ClientGreetingSection() {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(0.dp, 0.dp, 20.dp, 20.dp))
            .fillMaxWidth()
            .height(150.dp)
            .background(MaterialTheme.colorScheme.primary), // Fundo verde
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Olá,", color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text("Cliente!", color = Color.White, fontSize = 24.sp)
        }
    }
}

@Composable
fun ClientRecentActivitiesSection() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Atividades recentes", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(8.dp))

        // Mock de atividades recentes para o cliente
        ClientActivityItem(name = "Nova refeição adicionada", date = "23 de Setembro, 08:37")
        ClientActivityItem(name = "Meta semanal atingida", date = "22 de Setembro, 18:15")
    }
}

@Composable
fun ClientActivityItem(name: String, date: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.resource__), // Substitua pelo ícone apropriado
            contentDescription = null,
            tint = MaterialTheme.colorScheme.background,
            modifier = Modifier
                .size(40.dp)
                .background(MaterialTheme.colorScheme.primary, shape = CircleShape)
                .padding(8.dp)
        )

        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(name, fontWeight = FontWeight.Bold)
            Text(date, fontSize = 14.sp, color = Color.Gray)
        }
    }
}

@Composable
fun ClientBottomMenu(
    onAddMealClick: () -> Unit,
    onMessagesClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = onAddMealClick,
            modifier = Modifier.size(48.dp) // Define o tamanho fixo do botão
        ) {
            Image(
                painter = painterResource(id = R.drawable.group_32), // Ícone de adicionar refeição
                contentDescription = "Adicionar Refeição",
                modifier = Modifier.fillMaxSize() // Ícone preenche o espaço do botão
            )
        }

        IconButton(
            onClick = onMessagesClick,
            modifier = Modifier.size(48.dp) // Define o tamanho fixo do botão
        ) {
            Icon(
                painter = painterResource(id = R.drawable.forum_24dp_e8eaed_fill0_wght400_grad0_opsz24__1__1), // Ícone de mensagens
                contentDescription = "Mensagens",
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.fillMaxSize() // Ícone preenche o espaço do botão
            )
        }
    }
}



@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewClientHomeScreen() {
    AppTheme(dynamicColor = false, darkTheme = false) {
        ClientHomeScreen()
    }
}