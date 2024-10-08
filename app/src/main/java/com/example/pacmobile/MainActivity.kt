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
import com.example.pacmobile.ui.screens.LoginNutricionista
import com.example.pacmobile.ui.screens.LoginNutricionistaStateHandler
import com.example.pacmobile.ui.screens.SelectionRoleScreen
import com.example.pacmobile.ui.screens.SplashScreen
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
    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") { SplashScreen(navController = navController) }
        composable("selection-role") { SelectionRoleScreen(navController = navController) }
        composable("main") { MainScreen() }
        composable("login-nutri") { LoginNutricionistaStateHandler() }
    }
}

@Composable
fun MainScreen() {
    // Implemente a tela principal aqui
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Preview() {
    AppTheme(darkTheme = false, dynamicColor = false) {
        MyApp()
    }
}
