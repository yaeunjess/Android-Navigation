package com.example.backstackandbottombar.screen

import android.window.SplashScreen
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.backstackandbottombar.navgraph.AuthScreen
import com.example.backstackandbottombar.navgraph.SPLASH
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue),
        contentAlignment = Alignment.Center
    ) {
        Text("Splash Screen")
    }

    LaunchedEffect(key1 = true) {
        // 네트워크 통신 가정
        delay(2000L)
        navController.navigate(route = AuthScreen.SignIn.route) {
            popUpTo(SPLASH) {
                inclusive = true
            }
            launchSingleTop = true
        }
    }
}