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
        composable("home") { /*TODO*/ }
        composable("login-nutricionista") { LoginNutricionistaStateHandler(navController = navController) }
        composable("forgot-password-nutricionista") { ForgotPasswordStateHandler(navController = navController) }
        composable("sign-up-nutricionista") { SignUpNutricionistaStateHandler(navController = navController) }
        composable("codigo-recuperação-nutricionista") { CodigoRecuperacaoStateHandler(navController = navController) }
        composable("nova-senha-nutricionista") { NovaSenhaStateHandler(navController = navController) }


        //Cliente
        composable("login-cliente") { /*TODO*/ }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Preview() {
    AppTheme(darkTheme = false, dynamicColor = false) {
        MyApp()
    }
}
