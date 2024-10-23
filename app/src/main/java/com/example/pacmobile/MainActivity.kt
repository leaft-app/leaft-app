package com.example.pacmobile


import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pacmobile.ui.screens.SelectionRoleScreen
import com.example.pacmobile.ui.screens.SplashScreen
import com.example.pacmobile.ui.screens.cliente.*
import com.example.pacmobile.ui.screens.nutricionista.*
import com.example.pacmobile.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme(darkTheme = false, dynamicColor = false) {
                MyApp() // Passa a lógica de permissão para dentro do MyApp
            }
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    val context = LocalContext.current

    val showCameraPreview = remember { mutableStateOf(false) }

    // Lançador para solicitar permissão de câmera
    val cameraPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            showCameraPreview.value = true // Exibir a pré-visualização da câmera se a permissão for concedida
        } else {
            Toast.makeText(context, "Permissão de câmera é necessária.", Toast.LENGTH_SHORT).show()
        }
    }

    // Verificar e solicitar a permissão dentro da composição
    LaunchedEffect(Unit) {
        when (ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA)) {
            PackageManager.PERMISSION_GRANTED -> {
                showCameraPreview.value = true // Se a permissão já estiver concedida
            }
            else -> {
                // Solicitar permissão se ainda não concedida
                cameraPermissionLauncher.launch(Manifest.permission.CAMERA)
            }
        }
    }

    NavHost(navController = navController, startDestination = "splash-screen") {
        //Inicio
        composable("splash-screen") { SplashScreen(navController = navController) }
        composable("selection-role") { SelectionRoleScreen(navController = navController) }

        //Nutricionista
        composable("home-nutricionista") { /*TODO*/ }
        composable("login-nutricionista") { LoginNutricionistaStateHandler(navController = navController) }
        composable("forgot-password-nutricionista") { ForgotPasswordStateHandler(navController = navController) }
        composable("sign-up-nutricionista") { SignUpNutricionistaStateHandler(navController = navController) }
        composable("codigo-recuperacao-nutricionista") { CodigoRecuperacaoStateHandler(navController = navController) }
        composable("nova-senha-nutricionista") { NovaSenhaStateHandler(navController = navController) }

        //Cliente
        composable("home-cliente") { /*TODO*/ }
        composable("login-cliente") { LoginClienteStateHandler(navController = navController) }
        composable("forgot-password-cliente") { EsqueceuSenhaClienteStateHandler(navController = navController) }
        composable("sign-up-camera-cliente") { SignUpClienteCameraStateHandler(navController = navController) }
        composable("sign-up-cliente/{nutricionistaId}") { backStackEntry ->
            SignUpClienteStateHandler(
                navController = navController,
                nutricionistaId = backStackEntry.arguments?.getString("nutricionistaId") ?: ""
            )
        }
        composable("codigo-recuperacao-cliente") { CodigoRecuperacaoClienteStateHandler(navController = navController) }
        composable("nova-senha-cliente") { NovaSenhaClienteStateHandler(navController = navController) }
    }
}
