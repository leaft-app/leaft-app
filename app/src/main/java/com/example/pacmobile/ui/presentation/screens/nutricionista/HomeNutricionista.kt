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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.pacmobile.R
import com.example.pacmobile.ui.presentation.screens.cliente.ClientHomeScreen
import com.example.pacmobile.ui.presentation.theme.AppTheme
import com.example.pacmobile.ui.presentation.viewmodel.NutritionistViewModel

@Composable
fun NutritionistHomeScreen(
    viewModel: NutritionistViewModel = viewModel(),
    navController: NavController = androidx.navigation.compose.rememberNavController()
) {
    val showQrCodeDialog = remember { mutableStateOf(false) }
    val nutritionistId by viewModel.currentUser.collectAsState()

    Scaffold(
        bottomBar = {
            BottomMenu(
                onQrCodeClick = { showQrCodeDialog.value = true },
                onPacientesClick = {
                    navController.navigate("pacientes-nutricionista") // Navegar para a tela de pacientes
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.background)
        ) {
            GreetingSection()
            DailyInteractionsSection()
            RecentActivitiesSection()

            if (showQrCodeDialog.value) {
                QrCodeDialog(nutritionistId = nutritionistId.toString() ?: "", onClose = { showQrCodeDialog.value = false })
            }
        }
    }
}



@Composable
fun GreetingSection() {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(0.dp, 0.dp, 20.dp, 20.dp))
            .fillMaxWidth()
            .height(150.dp)
            .background(MaterialTheme.colorScheme.primary)
        ,
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Olá,", color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text("Usuário!", color = Color.White, fontSize = 24.sp)
        }
    }
}

@Composable
fun DailyInteractionsSection() {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text("Interações do Dia",
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
            fontSize = 18.sp)
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            //Essa parte tem que relacionar com o banco
            InteractionCard(iconResId = R.drawable.mail_24dp_e8eaed_fill0_wght400_grad0_opsz24_1, label = "Enviados", count = 12)
            InteractionCard(iconResId = R.drawable.mark_email_read_24dp_e8eaed_fill0_wght400_grad0_opsz24_1, label = "Pendentes", count = 3)
            InteractionCard(iconResId = R.drawable.mark_email_unread_24dp_e8eaed_fill0_wght400_grad0_opsz24_1, label = "Respostas", count = 1)
        }
    }
}

@Composable
fun InteractionCard(iconResId: Int, label: String, count: Int) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(MaterialTheme.colorScheme.surface)
            .padding(16.dp)
            .width(80.dp)
            .height(100.dp)
    ) {
        Image(
            painter = painterResource(id = iconResId),
            contentDescription = label,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primary)
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = label, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
        Text(text = count.toString(), fontSize = 16.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun RecentActivitiesSection() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Atividades recentes", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(8.dp))

        //Essa parte tem que relacionar com o banco
        ActivityItem(name = "Guest", email = "foo.bar@gmail.com")
        ActivityItem(name = "Guest", email = "foo.bar@gmail.com")
    }
}

@Composable
fun ActivityItem(name: String, email: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.vector_1_),
            contentDescription = null,
            tint = Color(0xFF2E7D32),
            modifier = Modifier.size(40.dp)
        )

        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(name, fontWeight = FontWeight.Bold)
            Text(email, fontSize = 14.sp, color = Color.Gray)
        }
    }
}


@Composable
fun QrCodeDialog(
    nutritionistId: String,
    onClose: () -> Unit,
    viewModel: NutritionistViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {

    LaunchedEffect(nutritionistId) {
        if (nutritionistId.isNotEmpty()) {
            viewModel.qrCodeBitmap
        }
    }

    val qrCodeBitmap by viewModel.qrCodeBitmap.collectAsState()

    Dialog(onDismissRequest = onClose) {
        Box(
            modifier = Modifier
                .size(300.dp)
                .background(Color.White, shape = RoundedCornerShape(12.dp))
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Compartilhe seu QR Code!", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Spacer(modifier = Modifier.height(8.dp))

                if (qrCodeBitmap != null) {
                    Image(
                        bitmap = qrCodeBitmap!!.asImageBitmap(),
                        contentDescription = "QR Code",
                        modifier = Modifier.size(200.dp)
                    )
                } else {
                    Text("Gerando QR Code...")
                }

                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = onClose) {
                    Text("Fechar")
                }
            }
        }
    }
}


@Composable
fun BottomMenu(
    onQrCodeClick: () -> Unit,
    onPacientesClick: () -> Unit // Ajuste: adicionando o callback de navegação para a lista de pacientes
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(Color.White)
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { /* Ação do Calendário */ }) {
            Icon(
                painter = painterResource(id = R.drawable.vector),
                contentDescription = "Calendário",
                tint = Color.Unspecified,
                modifier = Modifier.size(24.dp)
            )
        }

        IconButton(onClick = onQrCodeClick) { // Chama a ação de abrir a modal
            Icon(
                painter = painterResource(id = R.drawable.qr_code_add_1),
                contentDescription = "QR Code",
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(48.dp)
            )
        }

        IconButton(onClick = onPacientesClick) { // Usa o callback de navegação para a lista de pacientes
            Icon(
                painter = painterResource(id = R.drawable.vector_1_),
                contentDescription = "Pacientes",
                tint = Color.Unspecified,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}
