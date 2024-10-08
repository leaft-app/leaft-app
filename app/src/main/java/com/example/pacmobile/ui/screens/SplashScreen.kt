package com.example.pacmobile.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.pacmobile.R
import com.example.pacmobile.ui.components.LoadingAnimation
import com.example.pacmobile.ui.theme.AppTheme
import kotlinx.coroutines.delay


@Composable
fun SplashScreen( modifier: Modifier = Modifier, navController: NavHostController) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier =
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Image(painter = painterResource(id = R.drawable.icon),
            contentDescription = "Image Logo",
            modifier = Modifier.size(177.dp,198.dp)
        )
        LoadingAnimation()
    }
    LaunchedEffect(Unit) {
        delay(2000)
        navController.navigate("selection-role") {
            popUpTo("splash") { inclusive = true }
        }
    }
}