package com.example.pacmobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pacmobile.ui.screens.nutricionista.CodigoRecuperacaoStateHandler
import com.example.pacmobile.ui.screens.nutricionista.ForgotPasswordStateHandler
import com.example.pacmobile.ui.screens.nutricionista.LoginNutricionistaStateHandler
import com.example.pacmobile.ui.screens.SelectionRoleScreen
import com.example.pacmobile.ui.screens.SplashScreen
import com.example.pacmobile.ui.screens.cliente.CodigoRecuperacaoClienteStateHandler
import com.example.pacmobile.ui.screens.cliente.EsqueceuSenhaClienteStateHandler
import com.example.pacmobile.ui.screens.cliente.LoginClienteStateHandler
import com.example.pacmobile.ui.screens.cliente.NovaSenhaClienteStateHandler
import com.example.pacmobile.ui.screens.cliente.SignUpClienteCameraStateHandler
import com.example.pacmobile.ui.screens.cliente.SignUpClienteStateHandler
import com.example.pacmobile.ui.screens.nutricionista.NovaSenhaStateHandler
import com.example.pacmobile.ui.screens.nutricionista.SignUpNutricionistaStateHandler
import com.example.pacmobile.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
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
        composable("codigo-recuperação-cliente") { CodigoRecuperacaoClienteStateHandler(navController = navController) }
        composable("nova-senha-cliente") { NovaSenhaClienteStateHandler(navController = navController) }



    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Preview() {
    AppTheme(darkTheme = false, dynamicColor = false) {
        MyApp()
    }
}
