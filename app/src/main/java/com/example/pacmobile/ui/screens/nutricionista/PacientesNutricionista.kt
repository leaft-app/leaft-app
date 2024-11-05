package com.example.pacmobile.ui.screens.nutricionista

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pacmobile.R
import com.example.pacmobile.ui.theme.AppTheme

data class Paciente(val nome: String, val email: String)

@Composable
fun ListaPacientesScreen(navController: NavController) {
    val pacientes = remember {
        listOf(
            Paciente("Guest", "isaac.graper@gmail.com"),
            Paciente("Guest", "foo.bar@gmail.com"),
            Paciente("Guest", "foo.bar@gmail.com"),
            Paciente("Guest", "foo.bar@gmail.com"),
            Paciente("Guest", "foo.bar@gmail.com")
        )
    }

    var searchQuery by remember { mutableStateOf("") }
    val filteredPacientes = pacientes.filter {
        it.nome.contains(searchQuery, ignoreCase = true) ||
                it.email.contains(searchQuery, ignoreCase = true)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(top = 45.dp, start = 25.dp, end = 25.dp)
    ) {
        Text(
            text = "Pacientes",
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
            fontSize = 24.sp,
        )

        Row(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.secondaryContainer)
                .fillMaxWidth()
                .height(3.dp)
        ){

        }

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(filteredPacientes) { paciente ->
                PacienteItem(
                    paciente = paciente,
                    onEditClick = {
                        // Navega para a tela de detalhes do paciente ao clicar no botão de edição
                        navController.navigate("detalhes-paciente/${paciente.nome}")
                    }
                )
            }
        }

        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = { Text("Search") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            singleLine = true,
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.search_24dp_e8eaed_fill0_wght400_grad0_opsz24_1),
                    contentDescription = "Ícone de pesquisa",
                    modifier = Modifier.background(MaterialTheme.colorScheme.secondaryContainer)
                )
            },
        )

        BottomMenu(onQrCodeClick = {
            navController.navigate("qr-code")
        },
            onPacientesClick =  {
                navController.navigate("pacientes-nutricionista")
            }
        )
    }
}

@Composable
fun PacienteItem(paciente: Paciente, onEditClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .padding(top = 20.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.group_34),
            contentDescription = null,
            modifier = Modifier
                .size(55.dp)
                .padding(8.dp)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = paciente.nome,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
            Text(
                text = paciente.email,
                fontSize = 14.sp,
                color = Color.Gray
            )
        }

        IconButton(onClick = onEditClick) {
            Image(
                painter = painterResource(id = R.drawable.group_21),
                contentDescription = "Opções",
                Modifier.size(20.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewListaPacientesScreen() {
    AppTheme(darkTheme = false, dynamicColor = false) {
        ListaPacientesScreen(navController = androidx.navigation.compose.rememberNavController())
    }
}
