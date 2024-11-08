package com.example.pacmobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pacmobile.ui.presentation.screens.SelectionRoleScreen
import com.example.pacmobile.ui.presentation.screens.SplashScreen
import com.example.pacmobile.ui.presentation.screens.cliente.*
import com.example.pacmobile.ui.presentation.screens.nutricionista.*
import com.example.pacmobile.ui.presentation.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme(darkTheme = false, dynamicColor = false) {
                MyApp()
            }
        }
    }
}


@Composable
fun MyApp() {
    val navController = rememberNavController()
    val context = LocalContext.current


    NavHost(navController = navController, startDestination = "splash-screen") {

        // SplashScreen
        composable("splash-screen") {
            SplashScreen(navController = navController)
        }

        // Seleção de Role (Cliente ou Nutricionista)
        composable("selection-role") {
            SelectionRoleScreen(navController = navController)
        }

        // Nutricionista
        composable("home-nutricionista") {
            NutritionistHomeScreen(navController = navController)
        }
        composable("pacientes-nutricionista") {
            ListaPacientesScreen(navController = navController)
        }
        composable("login-nutricionista") {
            LoginNutricionistaStateHandler(navController = navController)
        }
        composable("forgot-password-nutricionista") {
            ForgotPasswordStateHandler(navController = navController)
        }
        composable("sign-up-nutricionista") {
            SignUpNutricionistaStateHandler(navController = navController)
        }
        composable("codigo-recuperacao-nutricionista") {
            CodigoRecuperacaoStateHandler(navController = navController)
        }
        composable("nova-senha-nutricionista") {
            NovaSenhaStateHandler(navController = navController)
        }

        // Cliente
        composable("home-cliente") {
            ClientHomeScreen(navController = navController)
        }
        composable("login-cliente") {
            LoginClienteStateHandler(navController = navController)
        }
        composable("forgot-password-cliente") {
            EsqueceuSenhaClienteStateHandler(navController = navController)
        }
        composable("sign-up-camera-cliente") {
            SignUpClienteCameraStateHandler(navController = navController)
        }
        composable("sign-up-cliente/{nutricionistaId}") { backStackEntry ->
            SignUpClienteStateHandler(
                navController = navController,
                nutricionistaId = backStackEntry.arguments?.getString("nutricionistaId") ?: ""
            )
        }
        composable("codigo-recuperacao-cliente") {
            CodigoRecuperacaoClienteStateHandler(navController = navController)
        }
        composable("nova-senha-cliente") {
            NovaSenhaClienteStateHandler(navController = navController)
        }
    }
}
